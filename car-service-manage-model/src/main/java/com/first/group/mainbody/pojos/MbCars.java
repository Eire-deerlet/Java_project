package com.first.group.mainbody.pojos;

import lombok.Data;

import java.io.Serializable;

/**
 * 车辆表
 * 该车主所拥有的的车辆
 */
@Data
public class MbCars implements Serializable {
    private Integer id;         // 自增主键id
    private Integer carOwnerId; // 车主id
    private String brand;       // 品牌
    private String series;      // 车系
    private String type;        // 车型
    private String plate;       // 车牌
    private String vin;         // 车架号
    private String engineNumber;    // 发动机号
}
