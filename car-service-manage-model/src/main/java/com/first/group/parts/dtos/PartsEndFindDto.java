package com.first.group.parts.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class PartsEndFindDto implements Serializable {

    private String type; // 商品备注
    private String image;    // 商品图片
    private String detail; // 商品详情


}
