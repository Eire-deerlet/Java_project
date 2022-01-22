package com.first.group.mapper;

import com.first.group.order.dtos.CloseOrderDto;
import com.first.group.order.dtos.OrderServiceDto;
import com.first.group.order.pojos.OrderService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OrderServiceMapper {

    List<OrderService> getOrderService(@Param("dto")OrderServiceDto dto);

    @Select("select * from order_service")
    List<OrderService> getAll();

    @Select("select * from order_service where id=#{id}")
    OrderService findById(@Param("id") Integer id);

    @Update("update order_service set is_closed=#{dto.isClosed} where id=#{dto.id}")
    void closeOrder(@Param("dto")CloseOrderDto dto);
}
