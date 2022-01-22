package com.first.group.settlement.dtos;

import com.first.group.dtos.PageRequestDto;
import lombok.Data;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.io.Serializable;
import java.util.Date;

/**
 * 配件商支付表
 */
@Data
public class ProviderPayDto extends PageRequestDto implements Serializable {

    private Integer merchantId; // 商家编号

    private String merchantName; // 商家名称

    private String paymentId; // 支付单号

    private String payee; // 收款人

    private Integer payType; // 支付类型

    private Integer status; // 支付状态 待支付 0  已支付 1

    private Date startTime; // 开始时间

    private Date endTime; // 结束时间

}
