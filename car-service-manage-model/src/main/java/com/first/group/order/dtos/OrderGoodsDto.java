package com.first.group.order.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderGoodsDto implements Serializable {

    /**
     * 商品id
     */
    private Integer id;

    /**
     * 订货单编号
     */
    private String orderNum;

    /**
     * 商品编码
     */
    private String goodsNum;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 规格型号
     */
    private String model;

    /**
     * 出厂编码
     */
    private String productNum;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 订货价
     */
    private Double price;

    /**
     * 订货量
     */
    private Integer orderAmount;

    /**
     * 商品金额
     */
    private Double orderSum;
}
