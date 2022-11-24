package edu.swu.cs.listener;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rabbitmq.client.Channel;
import edu.swu.cs.Constants.SystemConstants;
import edu.swu.cs.entity.OrderInfo;
import edu.swu.cs.service.IOrderInfoService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Component
@RabbitListener(queues = SystemConstants.ORDER_RELEASE_STOCK_QUEUE)
public class OrderListener {
    @Autowired
    private IOrderInfoService orderInfoService;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    //因为这里mq有可能会消息重复消费，所以我们这里设计为幂等接口
    @RabbitHandler
    public void listener(OrderInfo orderInfo, Message message, Channel channel) throws IOException {
        try {
            LambdaQueryWrapper<OrderInfo> lambdaQueryWrapper=new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(OrderInfo::getOrderId,orderInfo.getOrderId());
            OrderInfo order = orderInfoService.getOne(lambdaQueryWrapper);
            //如果没有order,说明在创建order的时候，由于本地事务回滚了，所以应该回滚库存
            if (Objects.isNull(order)){
                rabbitTemplate.convertAndSend(SystemConstants.ORDER_EXCHANGE,"stock.release",orderInfo.getProductId());
            }//如果还未支付，就设置订单的状态为取消，并且解锁库存
            else if (order.getOrderStatus()==0){
                order.setOrderStatus(3);
                orderInfoService.updateById(order);
                rabbitTemplate.convertAndSend(SystemConstants.ORDER_EXCHANGE,"stock.release",order.getProductId());
            } else if (order.getOrderStatus() == 3) {
                rabbitTemplate.convertAndSend(SystemConstants.ORDER_EXCHANGE,"stock.release",order.getProductId());
            }
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }catch (Exception e){
            System.out.println("订单关闭异常" + e.getMessage());
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
        }


    }
}
