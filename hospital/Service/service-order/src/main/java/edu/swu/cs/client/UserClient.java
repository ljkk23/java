package edu.swu.cs.client;

@FeignClient(name = "service-order",fallback = OrderClientImpl.class)
public interface OrderClient {

    //根据课程id和用户id查询订单表中订单状态
    @GetMapping("/eduorder/order/isBuyCourse/{courseId}/{memberId}")
    public boolean isBuyCourse(@PathVariable("courseId") String courseId, @PathVariable("memberId") String memberId);
}