package com.first.group.settlement.mapper;

import com.first.group.settlement.pojos.SmBillsDetail;
import org.apache.ibatis.annotations.Param;

public interface BillsDetailsMapper {
    // 通过账单id查询账单详情页
    SmBillsDetail findDetailsById(@Param("billId") String billId);
}
