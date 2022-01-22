package com.first.group.settlement.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SmPayDto implements Serializable {

    private String paymentId; // 支付单号

    private String payee; // 收款人

    private Date payTime; // 支付日期

    private Double money; // 付款金额

    private Integer payType; // 支付类型
}
