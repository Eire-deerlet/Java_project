package com.first.group.settlement.dtos;

import com.first.group.dtos.PageRequestDto;
import lombok.Data;
import org.springframework.data.domain.PageRequest;

import java.io.Serializable;
import java.util.Date;

@Data
public class SmBillDto extends PageRequestDto implements Serializable {

    private String billId;  // 账单编号

    private String name; // 客户名称 / 商户名称

    private Integer status; // 支付状态   0  待支付，1  已支付，2  支付失败，3  支付异常，4  已撤销

    private Date start; // 开始日期

    private Date end; // 结束日期

    private Integer billType; // 账单类型

    private Integer subtype; // 账单子类型
}
