package com.first.group.settlement.mapper;

import com.first.group.settlement.dtos.ProviderPayDto;
import com.first.group.settlement.dtos.SmBillDto;
import com.first.group.settlement.pojos.SmBill;
import com.first.group.settlement.pojos.SmBePay;
import com.first.group.settlement.pojos.SmPay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderBillMapper {
    // 查询配件商账单首页列表
    List<SmBill> findAll(@Param("dto") SmBillDto dto);

    // 配件商待支付列表
    List<SmBePay> findBePay(@Param("dto") ProviderPayDto dto);

    // 配件商支付列表
    List<SmPay> findPay(@Param("dto") ProviderPayDto dto);
}
