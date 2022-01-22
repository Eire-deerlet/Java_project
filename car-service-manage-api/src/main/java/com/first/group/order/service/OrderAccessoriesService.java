package com.first.group.order.service;

import com.first.group.dtos.ResponseResult;
import com.first.group.order.dtos.OrderAccessoriesDto;

import java.util.List;

public interface OrderAccessoriesService {

    /**
     * 查询配件订单
     * @param dto
     * @return
     */
    ResponseResult<List<OrderAccessoriesDto>> findList(OrderAccessoriesDto dto);
}
