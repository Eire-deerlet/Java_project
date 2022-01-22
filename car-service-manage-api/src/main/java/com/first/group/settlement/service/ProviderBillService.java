package com.first.group.settlement.service;

import com.first.group.dtos.ResponseResult;
import com.first.group.settlement.dtos.OrderPayDto;
import com.first.group.settlement.dtos.ProviderPayDto;
import com.first.group.settlement.dtos.SmBillDto;

public interface ProviderBillService {
    /**
     * 查询配件商首页列表
     * @param dto
     * @return
     */
    ResponseResult findAll(SmBillDto dto);

    /**
     * 配件商待支付列表
     * @param dto
     * @return
     */
    ResponseResult providerBePay(ProviderPayDto dto);

    /**
     * 配件商支付列表
     * @param dto
     * @return
     */
    ResponseResult providerPay(ProviderPayDto dto);

    /**
     * 配件商需支付账单
     * @param merchantId
     * @return
     */
    ResponseResult providerOrderPay(Integer merchantId);

    /**
     * 查询需支付列表
     * @param dto
     * @return
     */
    ResponseResult findOrderPay(OrderPayDto dto);
}
