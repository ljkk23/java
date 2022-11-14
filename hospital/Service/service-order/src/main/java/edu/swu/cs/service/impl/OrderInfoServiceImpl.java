package edu.swu.cs.service.impl;

import edu.swu.cs.client.ProductClient;
import edu.swu.cs.client.UserClient;
import edu.swu.cs.domain.FeignVO.DoctorFeignVO;
import edu.swu.cs.domain.FeignVO.PatientVo;
import edu.swu.cs.domain.FeignVO.ProductVO;
import edu.swu.cs.domain.ResponseResult;
import edu.swu.cs.entity.OrderInfo;
import edu.swu.cs.entity.VO.OrderVO;
import edu.swu.cs.mapper.OrderInfoMapper;
import edu.swu.cs.service.IOrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author liujian
 * @since 2022-11-10
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private ProductClient productClient;
    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 60L;


    @Override
    public ResponseResult getOrderByID(Long orderId) {
        long startTime=System.currentTimeMillis(); //获取开始时间
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        OrderVO orderVO=new OrderVO();
        //要测的程序或方法


        //通过openfeign远程调用product中的通过id获取product的信息，以及patientID获取patient的信息，组装成订单信息返回给前端
        OrderInfo orderInfo = this.baseMapper.selectById(orderId);

        orderVO.setOrderId(orderInfo.getProductId())
                .setCreateTime(orderInfo.getCreateTime())
                .setOrderStatus(orderInfo.getOrderStatus());
//        ProductVO productVO = productClient.FeignGetProductInfo(orderInfo.getProductId());
//        orderVO.setDate(productVO.getDate());

        CompletableFuture<ProductVO> productFuture = CompletableFuture.supplyAsync(() -> {
            //1.获取product的信息
            ProductVO productVO = productClient.FeignGetProductInfo(orderInfo.getProductId());
            orderVO.setDate(productVO.getDate());
            return productVO;

        }, executor);
        //ProductVO productVO = productClient.FeignGetProductInfo(orderInfo.getProductId());
        CompletableFuture<Void> doctorFuture = productFuture.thenAcceptAsync((res) -> {
            //根据product中的医生id查询医生的信息
            DoctorFeignVO doctorFeignVO = userClient.FeignGetDoctorInfo(res.getDoctorId());
            orderVO.setDeptId(doctorFeignVO.getDeptId())
                    .setDoctorAvatar(doctorFeignVO.getAvatar())
                    .setDoctorEmail(doctorFeignVO.getEmail())
                    .setDoctorPhonenumber(doctorFeignVO.getPhonenumber())
                    .setDoctorSex(doctorFeignVO.getSex())
                    .setTitle(doctorFeignVO.getTitle())
                    .setDoctorUserName(doctorFeignVO.getUserName())
                    .setAmount(doctorFeignVO.getAmount());
        }, executor);

//        DoctorFeignVO doctorFeignVO = userClient.FeignGetDoctorInfo(productVO.getDoctorId());
//        orderVO.setDeptId(doctorFeignVO.getDeptId())
//                .setDoctorAvatar(doctorFeignVO.getAvatar())
//                .setDoctorEmail(doctorFeignVO.getEmail())
//                .setDoctorPhonenumber(doctorFeignVO.getPhonenumber())
//                .setDoctorSex(doctorFeignVO.getSex())
//                .setTitle(doctorFeignVO.getTitle())
//                .setDoctorUserName(doctorFeignVO.getUserName())
//                .setAmount(doctorFeignVO.getAmount());

        CompletableFuture<Void> patientFuture = CompletableFuture.runAsync(() -> {
            //1.获取patient的信息
            PatientVo patientVo = userClient.FeignGetPatientInfo(orderInfo.getPatientId());
            orderVO.setPatientAge(patientVo.getAge())
                    .setPatientCardId(patientVo.getCardId())
                    .setPatientSex(patientVo.getSex())
                    .setPatientPhonenumber(patientVo.getPhonenumber())
                    .setPatientUserName(patientVo.getUserName());

        }, executor);

        PatientVo patientVo = userClient.FeignGetPatientInfo(orderInfo.getPatientId());
        orderVO.setPatientAge(patientVo.getAge())
                .setPatientCardId(patientVo.getCardId())
                .setPatientSex(patientVo.getSex())
                .setPatientPhonenumber(patientVo.getPhonenumber())
                .setPatientUserName(patientVo.getUserName());

        //等待所有任务都完成
        try {
            CompletableFuture.allOf(doctorFuture,patientFuture,productFuture).get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        long endTime=System.currentTimeMillis(); //获取结束时间

        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

        return ResponseResult.okResult(orderVO);
    }
}
