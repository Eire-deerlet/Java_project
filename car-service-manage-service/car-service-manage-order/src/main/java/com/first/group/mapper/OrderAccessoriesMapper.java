package com.first.group.mapper;


import com.first.group.order.dtos.OrderAccessoriesDto;
import com.first.group.order.pojos.OrderAccessories;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderAccessoriesMapper {

    List<OrderAccessories> findList(@Param("dto") OrderAccessoriesDto dto);

    @Select("select * from order_accessories")
    List<OrderAccessories> findAll();
}
