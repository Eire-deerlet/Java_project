package com.first.group.settlement.pojos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SmBill implements Serializable {

    private Integer id; // 主键id

    private String billId; // 账单id

    private String merchantName; // 客户名称 / 商家名称

    private String billAbstract; // 账单摘要

    private Double money; // 待收金额 / 应付金额

    private Date createdTime; // 创建时间

    private Integer type; // 账单类型  0  销售账单，1  配件账单， 2  服务账单

    private Integer subtype; // 账单子类型  0  配件销售账单，1   服务销售账单， 2  退货退款账单

    private Integer status; // 支付状态  0  待支付，1  已支付，2  支付失败，3  支付异常，4  已撤销
}
