package com.first.group.parts.pojos;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;


@Data
@Document("pc_brand")
public class PcBrand implements Serializable {
    @Id
    private int id;


    /**
     * 品牌编码
     */
    @Field("coding")
    private Integer coding;
    /**
     * 品牌名称
     */
    @Field("name")
    private String name;
    /**
     * 品牌LOGO
     */
    @Field("logo")
    private String logo;


    /**
     * 创建时间
     */
    @Field("create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @Field("update_time")
    private Date updateTime;
    /**
     * 排序
     */
    @Field(value = "sort")
    private Integer sort;




}
