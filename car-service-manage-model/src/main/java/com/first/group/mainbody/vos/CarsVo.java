package com.first.group.mainbody.vos;

import lombok.Data;

import java.io.Serializable;

@Data
public class CarsVo implements Serializable {
    private String brand;   // 品牌
    private String series;  // 车系
    private String type;    // 车型
    private String plate;   // 车牌
    private String vin;     // 车架号
    private String engine_number;   // 发动机号
}
