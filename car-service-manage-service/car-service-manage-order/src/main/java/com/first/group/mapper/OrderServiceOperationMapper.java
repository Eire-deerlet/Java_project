package com.first.group.mapper;

import com.first.group.order.pojos.OrderServiceOperation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderServiceOperationMapper {

    @Select("select * from order_service_operation where order_id =#{id}")
    List<OrderServiceOperation> getOperation(@Param("id") Integer id);
}
