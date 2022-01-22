package com.first.group.parts.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class PartsSearchDto implements Serializable {

    private String accessories; // 配件商
    private String coding;    // 配件编码
    private String name; // 分类名称
    private String model; // 规格型号
    private String marque; // 配件品牌
    private String partsName; // 配件分类

}
