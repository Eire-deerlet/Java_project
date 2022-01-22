package com.first.group.settlement.mapper;

import com.first.group.settlement.dtos.OrderPayDto;
import com.first.group.settlement.pojos.SmOrderPay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderPayMapper {
    // 通过商家id查询需支付的账单
    List<SmOrderPay> findByMerchantId(@Param("merchantId") Integer merchantId);

    // 根据条件查询订单信息
    List<SmOrderPay> findOrderPay(@Param("dto") OrderPayDto dto);
}
