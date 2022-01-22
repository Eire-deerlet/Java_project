package com.first.group.parts.pojos;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;


@Data
@Document("pc_Parts_two")
public class PcPartsTwo implements Serializable {
    /**
     * 二级分类编码
     */
    @Field("coding")
    @Id
    private int coding;


    /**
     * 二级分类名称
     */
    @Field("name")
    private String name;
    /**
     * 分类图片
     */
    @Field("image")
    private String image;
    /**
     * 对应一级表的分类编码
     */
    @Field("parts_one_condig")
    private Integer partsOneCondig;


    /**
     * 修改时间
     */
    @Field("update_time")
    private Date updateTime;
    /**
     * 创建时间
     */
    @Field("create_time")
    private Date createTime;



    /**
     * 排序
     */
    @Field("sort")
    private Integer sort;

}
