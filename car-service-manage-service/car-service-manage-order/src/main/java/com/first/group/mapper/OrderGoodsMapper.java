package com.first.group.mapper;

import com.first.group.order.pojos.OrderGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderGoodsMapper {

    @Select("select * from order_goods where id =#{goodsId}")
    OrderGoods getOrderGoods(@Param("goodsId") Integer goodsId);
}
