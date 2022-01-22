package com.first.group.parts.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class OneTwoDto implements Serializable {
    private Integer coding;    // 二级分类编码
    private String name; // 分类名称
    private Integer sort; // 排序
    private String image; // 分类图片

}
