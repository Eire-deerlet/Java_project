package com.first.group.settlement.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class SmBePayDto implements Serializable {

    private Integer merchantId; // 商家编号

    private String merchantName; // 商家名称

    private Double money; // 账单金额

}
