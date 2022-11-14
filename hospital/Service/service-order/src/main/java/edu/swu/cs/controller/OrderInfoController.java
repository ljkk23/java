package edu.swu.cs.controller;


import edu.swu.cs.client.UserClient;
import edu.swu.cs.domain.FeignVO.DoctorFeignVO;
import edu.swu.cs.domain.ResponseResult;
import edu.swu.cs.entity.OrderInfo;
import edu.swu.cs.enums.AppHttpCodeEnum;
import edu.swu.cs.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author liujian
 * @since 2022-11-10
 */
@RestController
@RequestMapping("/order-info")
public class OrderInfoController {
    @Autowired
    private IOrderInfoService orderInfoService;


    @GetMapping("/createOrder")
    public ResponseResult addArticle(Long userID,Long patientID,Long productID){
        OrderInfo orderInfo=new OrderInfo(productID,userID,patientID,userID);
        if (!orderInfoService.save(orderInfo)){
            return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR,"插入数据库出错");
        }
        return ResponseResult.okResult();
    }
    @GetMapping("/getOrderByID")
    public ResponseResult getOrderByID(Long orderId){
        return orderInfoService.getOrderByID(orderId);
    }
}

