package com.first.group.settlement.mapper;

import com.first.group.settlement.dtos.SmBillDto;
import com.first.group.settlement.dtos.SupplierPayDto;
import com.first.group.settlement.pojos.SmBePay;
import com.first.group.settlement.pojos.SmBill;
import com.first.group.settlement.pojos.SmPay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierBillMapper {
    // 查询服务商账单首页列表
    List<SmBill> findAll(@Param("dto") SmBillDto dto);

    // 查询服务商待支付列表
    List<SmBePay> findBePay(@Param("dto") SupplierPayDto dto);

    // 查询服务商支付列表
    List<SmPay> findPay(@Param("dto") SupplierPayDto dto);
}
