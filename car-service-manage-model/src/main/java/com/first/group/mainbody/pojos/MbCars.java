package com.first.group.mainbody.pojos;

import lombok.Data;

@Data
public class MbCars{
    private Integer id;         // 自增主键id
    private Integer carOwnerId; // 车主id
    private String brand;       // 品牌
    private String series;      // 车系
    private String type;        // 车型
    private String plate;       // 车牌
    private String vin;         // 车架号
    private String engineNumber;    // 发动机号
}
