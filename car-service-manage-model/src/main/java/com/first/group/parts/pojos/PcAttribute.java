package com.first.group.parts.pojos;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;


@Data
@Document("pc_attribute")
public class PcAttribute implements Serializable {
    @Id
    private Integer id;


    /**
     * 二级表主键
     */
    @Field("parts_two_coding")
    private Integer partsTwoCoding;
    /**
     * 表单类型 1 2 3 4各种选项框
     */
    @Field("type")
    private Integer type;
    /**
     * 表单类型 1 2 3 4各种选项框
     */
    @Field("name")
    private Integer name;


    /**
     * 单位
     */
    @Field("unit")
    private Integer unit;
    /**
     * 可选项
     */
    @Field("options")
    private String options;
    /**
     * 默认选项
     */
    @Field( "default_option")
    private String defaultOption;

    /**
     * 搜索项  1可用 0禁用
     */
    @Field("search_terms")
    private int searchTerms;
    /**
     * 是否必填  1可用 0禁用
     */
    @Field("required")
    private int required;


}
