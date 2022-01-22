package com.first.group.order.service;

import com.first.group.dtos.ResponseResult;
import com.first.group.order.dtos.OrderDetailsDto;
import org.apache.ibatis.annotations.Mapper;


public interface OrderDetailsService {

    /**
     * 查看订单详情
     * @param id
     * @return
     */
    ResponseResult<OrderDetailsDto> getDetails(Integer id);
}
