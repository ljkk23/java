package edu.swu.cs.listener;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rabbitmq.client.Channel;
import edu.swu.cs.Constants.SystemConstants;
import edu.swu.cs.entity.Ware;
import edu.swu.cs.service.IWareService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Component
@RabbitListener(queues = SystemConstants.RELEASE_STOCK_QUEUE)
public class WareListener {
    @Autowired
    private IWareService wareService;

    /**  @Transactional
        TODO:因为这里mq有可能会消息重复消费，所以我们这里设计为幂等接口,
    方案一：第一次访问时，在redis中判断是否有该key，没有就加进去，有就说明多次访问了
    方案二: 设计一张防重表，给每个操作一个唯一id,然后插入数据库，和第一次一样，只不过是访问数据库罢了
     *
     * @param productID
     * @param message
     * @param channel
     * @throws IOException
     */
    @RabbitHandler
    public void listener(Long productID, Message message, Channel channel) throws IOException {
        try {
            LambdaQueryWrapper<Ware> lambdaQueryWrapper=new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(Ware::getProductId,productID);
            Ware ware = wareService.getOne(lambdaQueryWrapper);
            //解锁库存
            ware.setAmount(ware.getAmount()-1);
            wareService.save(ware);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }catch (Exception e){
            System.out.println("库存解锁异常" + e.getMessage());
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
        }

    }
    @RabbitHandler
    public void listener2(String productID, Message message, Channel channel) throws IOException {
        System.out.println("dddd");
        try {
            LambdaQueryWrapper<Ware> lambdaQueryWrapper=new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(Ware::getProductId,productID);
            Ware ware = wareService.getOne(lambdaQueryWrapper);
            //解锁库存
            ware.setLockAmount(ware.getLockAmount()-1);
            wareService.updateById(ware);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }catch (Exception e){
            System.out.println("库存解锁异常" + e.getMessage());
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
        }

    }
}