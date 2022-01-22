package com.first.group.settlement.pojos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SmOrderPay implements Serializable {

    private Integer id; // 主键id

    private String billId; // 账单id

    private Integer merchantId; // 商家编号

    private String merchantName; // 商家名称

    private String billAbstract; // 账单摘要

    private Double money; // 应付金额

    private Date createdTime; // 生成日期

    private String type; // 账单类型
}
