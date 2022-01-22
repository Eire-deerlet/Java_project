package com.first.group.order.service;

import com.first.group.dtos.ResponseResult;
import com.first.group.order.pojos.OrderServiceDetails;

public interface OrderServiceDetailsService {

    /**
     * 查看服务订单详情
     * @param id
     * @return
     */
    ResponseResult<OrderServiceDetails> getDetails(Integer id);
}
