package edu.swu.cs.Constants;

public class SystemConstants
{
    /**
     *  文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;
    /**
     *  文章是正常分布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;

    public static final int LINK_STATUS_NORMAL = 0;
    //权限菜单中menutype为C
    public static final String MENU = "C";
    //权限菜单中menutype为F
    public static final String BUTTON = "F";
    //权限菜单中status为正常
    public static final int STATUS_NORMAL = 0;

    //订单交换机
    public static final String ORDER_EXCHANGE = "order-event-exchange";
    //订单解锁库存的queue
    public static final String ORDER_RELEASE_STOCK_QUEUE = "order.release.stock.queue";
    //订单的延迟队列

    public static final String ORDER_DELAY_QUEUE = "order.delay.queue";
    //库存的解锁队列
    public static final String RELEASE_STOCK_QUEUE = "stock.release.stock.queue";



}