package com.first.group.parts.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class BrandAddDto implements Serializable {
    private Integer coding;    // 品牌编码
    private String name; // 品牌名称
    private Integer sort; // 排序
    private String logo; // 配牌logo

}
