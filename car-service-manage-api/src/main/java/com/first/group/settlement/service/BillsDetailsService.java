package com.first.group.settlement.service;

import com.first.group.dtos.ResponseResult;

public interface BillsDetailsService {
    /**
     * 查看账单详情页
     * @param billId
     * @return
     */
    ResponseResult billsDetails(String billId);
}
