package com.first.group.order.service;

import com.first.group.dtos.ResponseResult;
import com.first.group.order.dtos.CloseOrderDto;
import com.first.group.order.dtos.OrderServiceDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderServiceService {

    /**
     * 查询服务订单
     * @param dto
     * @return
     */
    ResponseResult<List<OrderServiceDto>> getOrderService(OrderServiceDto dto);

    /**
     * 关闭待处理订单
     * @param dto
     */
    ResponseResult closeOrder(CloseOrderDto dto);



}
