package com.first.group.settlement.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderPayDto implements Serializable {

    private String billId; // 账单id

    private String type; // 账单类型

    private Date startTime; // 开始时间

    private Date endTime; // 结束时间
}
