package com.first.group.mapper;

import com.first.group.order.pojos.OrderServiceItems;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderServiceItemsMapper {

    @Select("select * from order_service_items where id =#{itemsId}")
    OrderServiceItems getServiceItems(@Param("itemsId") Integer itemsId);
}
