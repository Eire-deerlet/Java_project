package com.first.group.order.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class OrderDetailsDto implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     *订货单编号
     */
    private String orderNum;

    /**
     * 订单时间
     */
    private Date createTime;

    /**
     * 订单状态
     */
    private Short status;

    /**
     * 收货方名称
     */
    private String recName;

    /**
     * 收货行政区域
     */
    private String recArea;

    /**
     * 收货地址
     */
    private String recAddress;

    /**
     * 订货人
     */
    private String buyer;

    /**
     * 订货人联系电话
     */
    private String buyerTelephone;

    /**
     * 配送方式
     */
    private String delivery;

    /**
     * 支付方式
     */
    private String pay;

    /**
     * 发货方名称
     */
    private String sentName;

    /**
     * 发货方行政区域
     */
    private String sentArea;

    /**
     * 发货地址
     */
    private String sentAddress;

    /**
     * 联系电话
     */
    private String sentTelephone;

    /**
     * 订单商品
     */
    List<OrderGoodsDto> goodsList;

    /**
     * 订单操作记录
     */
    List<OrderOperationDto> operationList;
}
