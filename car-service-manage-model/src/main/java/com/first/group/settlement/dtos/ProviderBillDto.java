package com.first.group.settlement.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 配件商账单dto
 */
@Data
public class ProviderBillDto implements Serializable {

    private String billId; // 账单编号

    private Date createdTime; // 创建时间

    private String merchantName; // 商家名称

    private String billAbstract; // 账单摘要

    private Integer type; // 账单类型 0 销售账单，1 配件账单，2 服务账单

    private Integer subtype; // 账单子类型  0  配件销售账单，1   服务销售账单， 2  退货退款账单

    private Double money; // 待收金额

    private Integer status; // 账单状态
}
