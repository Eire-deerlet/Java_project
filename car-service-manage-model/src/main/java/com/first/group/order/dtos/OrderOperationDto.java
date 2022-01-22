package com.first.group.order.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderOperationDto implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 操作时间
     */
    private Date createTime;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态
     */
    private Short status;

    /**
     * 操作人
     */
    private String name;
}
