package com.first.group.order.dtos;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderServiceDto implements Serializable {

    /**
     * 订单编号
     */
    private Integer id;

    /**
     * 订单时间
     */
    private Date createTime;

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
     * 支付状态
     */
    private Short payStatus;

    /**
     * 订单状态
     */
    private Short status;

    /**
     * 订单金额
     */
    private Double total;

    /**
     * 订单是否超时未处理
     */
    private Short isTimeout;

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 页大小
     */
    private Integer pageSize;

    /**
     * 早于订单时间
     */
    private Date beforeTime;

    /**
     * 晚于订单时间
     */
    private Date afterTime;

    /**
     * 关闭状态
     */
    private Short isClosed;
}
