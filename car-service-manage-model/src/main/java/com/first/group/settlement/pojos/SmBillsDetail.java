package com.first.group.settlement.pojos;

import lombok.Data;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.io.Serializable;
import java.util.Date;

@Data
public class SmBillsDetail implements Serializable {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 账单编号
     */
    private String billId;

    /**
     * 账单摘要
     */
    private String billAbstract;

    /**
     * 账单金额
     */
    private Double money;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 付款方
     */
    private String payer;

    /**
     * 付款方名称
     */
    private String payerName;

    /**
     * 付款方编码
     */
    private Integer payerNum;

    /**
     * 付款方地址
     */
    private String payerAddress;

    /**
     * 付款人
     */
    private String payerUser;

    /**
     * 付款人手机号
     */
    private String payerMobile;

    /**
     * 收款方
     */
    private String payee;

    /**
     * 收款方名称
     */
    private String payeeName;

    /**
     * 收款方编码
     */
    private Integer payeeNum;

    /**
     * 收款方地址
     */
    private String payeeAddress;

    /**
     * 收款人
     */
    private String payeeUser;

    /**
     * 收款人手机号
     */
    private String payeeMobile;

    /**
     * 操作时间
     */
    private Date operationTime;

    /**
     * 操作类型
     */
    private String operationType;

    /**
     * 描述
     */
    private String describe;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 操作员
     */
    private String operationUser;
}
