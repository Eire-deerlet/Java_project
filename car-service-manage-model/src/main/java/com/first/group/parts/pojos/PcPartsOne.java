package com.first.group.parts.pojos;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;


@Data
@Document("pc_Parts_one")
public class PcPartsOne implements Serializable {
    /**
     * 配件分类编码
     */
    @Field("coding")
    @Id
    private int coding;


    /**
     * 配件分类名称
     */
    @Field("name")
    private String name;
    /**
     * 配件类型
     */
    @Field("type")
    private String type;
    /**
     * 1表示有子类 0表示没有子类
     */
    @Field("state")
    private int state;

    /**
     * 排序
     */
    @Field("sort")
    private Integer sort;

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




}
