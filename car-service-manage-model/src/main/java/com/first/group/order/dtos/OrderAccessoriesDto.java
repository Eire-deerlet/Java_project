package com.first.group.order.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderAccessoriesDto implements Serializable {

    /**
     * 订单编号
     */
    private Integer id;

    /**
     * 订单时间
     */
    private Date createTime;

    /**
     * 早于订单时间
     */
    private Date beforeTime;

    /**
     * 晚于订单时间
     */
    private Date afterTime;

    /**
     * 商家名称
     */
    private String store;

    /**
     * 商家电话
     */
    private String storeTelephone;

    /**
     * 客户名称
     */
    private String client;

    /**
     * 客户电话
     */
    private String cliTelephone;

    /**
     * 订单状态 1：待支付  2：待审核  3：已审核  4：待发货  5：已发货  6：正在配送  7：待签收
     *        8：已收货  9：已确认  10：已完成  11：退款已完成  12：待评价
     */
    private Short status;

    /**
     * 订单金额
     */
    private Double total;

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 页大小
     */
    private Integer pageSize;
}
