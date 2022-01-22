package com.first.group.settlement.pojos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SmPay implements Serializable {

    private Integer id; // 主键id

    private String paymentId; // 支付单号

    private String payee; // 收款人

    private Date payTime; // 支付时间

    private Double money; // 账单金额

    private Integer payType; // 支付类型 0 支票支付，1 银行卡转账，2 线下其他，3 现金支付
}
