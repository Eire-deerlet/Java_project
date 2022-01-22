package com.first.group.mapper;

import com.first.group.order.pojos.OrderOperation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderOperationMapper {

    @Select("select * from order_operation where order_id =#{id}")
    List<OrderOperation> getOperation(@Param("id") Integer id);
}
