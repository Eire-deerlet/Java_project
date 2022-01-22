package com.first.group.order.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderServiceItemsDto implements Serializable {

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

