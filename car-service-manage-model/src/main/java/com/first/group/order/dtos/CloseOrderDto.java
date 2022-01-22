package com.first.group.order.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class CloseOrderDto implements Serializable {

    /**
     * 订单id
     */
    private Integer id;

    /**
     * 超时状态
     */
    private Short isTimeout;

    /**
     * 关闭状态 1：关闭 0：开启
     */
    private Short isClosed;
}
