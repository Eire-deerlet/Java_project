package com.first.group.parts.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class OneAddDto implements Serializable {
    private Integer coding;    // 配件分类编码
    private String name; // 分类名称
    private Integer sort; // 排序
    private String type; // 配件类型

}
