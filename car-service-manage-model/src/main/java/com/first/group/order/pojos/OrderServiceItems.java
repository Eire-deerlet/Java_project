package com.first.group.order.pojos;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderServiceItems implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * 服务项目名称
     */
    private String name;

    /**
     * 价格
     */
    private Double price;

    /**
     * 服务费总金额
     */
    private Double total;
}

