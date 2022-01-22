package com.first.group.mapper;

import com.first.group.order.pojos.OrderServiceDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderServiceDetailsMapper {

    @Select("select * from order_service_details where order_id =#{id}")
    OrderServiceDetails getDetails(@Param("id") Integer id);
}
