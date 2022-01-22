package com.first.group.settlement.service;

import com.first.group.dtos.ResponseResult;
import com.first.group.settlement.dtos.SmBillDto;
import com.first.group.settlement.dtos.SupplierBillDto;
import com.first.group.settlement.dtos.SupplierPayDto;

public interface SupplierBillService {
    /**
     * 查询服务商账单列表
     * @param dto
     * @return
     */
    ResponseResult findAll(SmBillDto dto);

    /**
     * 服务商待支付列表
     * @param dto
     * @return
     */
    ResponseResult supplierBePay(SupplierPayDto dto);

    /**
     * 服务商支付列表
     * @param dto
     * @return
     */
    ResponseResult supplierPay(SupplierPayDto dto);
}
