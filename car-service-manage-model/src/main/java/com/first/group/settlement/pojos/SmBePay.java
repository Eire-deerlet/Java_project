package com.first.group.settlement.pojos;

import lombok.Data;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.io.Serializable;
import java.util.Date;

@Data
public class SmBePay implements Serializable {

    private Integer id; // 主键id

    private Integer merchantId; // 商家编号

    private String merchantName; // 商家名称

    private Double money; // 账单金额

}
