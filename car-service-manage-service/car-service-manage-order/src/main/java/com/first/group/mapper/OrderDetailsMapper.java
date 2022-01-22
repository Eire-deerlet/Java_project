package com.first.group.mapper;

import com.first.group.order.pojos.OrderDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderDetailsMapper {

    @Select("select * from order_details where order_id =#{id}")
    OrderDetails getDetails(@Param("id") Integer id);
}
