package com.first.group.settlement.mapper;

import com.first.group.settlement.dtos.SmBillDto;
import com.first.group.settlement.pojos.SmBill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmBillMapper {
    // 查询车主账单首页列表
    List<SmBill> findAll(@Param("dto") SmBillDto dto);
}
