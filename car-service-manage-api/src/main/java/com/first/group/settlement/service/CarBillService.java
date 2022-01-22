package com.first.group.settlement.service;

import com.first.group.dtos.ResponseResult;
import com.first.group.settlement.dtos.SmBillDto;

public interface CarBillService {
    /**
     * 查询首页车主账单
     * @param dto
     * @return
     */
    ResponseResult findAll(SmBillDto dto);
}
