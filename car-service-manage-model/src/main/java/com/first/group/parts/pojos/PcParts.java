package com.first.group.parts.pojos;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;


@Data
@Document("pc_prats")
public class PcParts implements Serializable {
    @Id
    private int id;


    /**
     * 配件商编码
     */
    @Field("parts_coding")
    private Integer partsCoding;
    /**
     * 配件商
     */
    @Field("Accessories")
    private String accessories;
    /**
     * 配件编码
     */
    @Field("coding")
    private String coding;


    /**
     * 配件名称
     */
    @Field("name")
    private String name;
    /**
     * 规格型号
     */
    @Field("model")
    private String model;
    /**
     * 配件分类
     */
    @Field(value = "parts_name")
    private String partsName;

    /**
     * 配件品牌
     */
    @Field(value = "marque")
    private String marque;

    /**
     * 价格
     */
    @Field("price")
    private Integer price;

    /**
     * 状态 上架1 下架0
     */
    @Field(value = "state")
    private int state;

    /**
     * 商品备注
     */
    @Field(value = "type")
    private String type;
    /**
     * 商品图片
     */
    @Field(value = "image")
    private String image;
    /**
     * 商品详情
     */
    @Field(value = "detail")
    private String detail;
}
