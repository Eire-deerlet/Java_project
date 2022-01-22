package com.first.group.order.service.impl;

import com.first.group.comment.BeanHelper;
import com.first.group.comment.dtos.AppHttpCodeEnum;
import com.first.group.dtos.ManagerCodeEnum;
import com.first.group.dtos.ResponseResult;
import com.first.group.exception.LeadNewsException;
import com.first.group.mapper.OrderDetailsMapper;
import com.first.group.mapper.OrderGoodsMapper;
import com.first.group.mapper.OrderOperationMapper;
import com.first.group.order.dtos.OrderDetailsDto;
import com.first.group.order.dtos.OrderGoodsDto;
import com.first.group.order.dtos.OrderOperationDto;
import com.first.group.order.pojos.OrderDetails;
import com.first.group.order.pojos.OrderGoods;
import com.first.group.order.pojos.OrderOperation;
import com.first.group.order.service.OrderDetailsService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;
    @Autowired
    private OrderGoodsMapper orderGoodsMapper;
    @Autowired
    private OrderOperationMapper orderOperationMapper;

    @Override
    public ResponseResult<OrderDetailsDto> getDetails(Integer id) {
        if(id==null){
            throw new LeadNewsException(ManagerCodeEnum.PARAM_INVALID);
        }
        //根据订单id查询相关订单详情
        OrderDetails orderDetails = orderDetailsMapper.getDetails(id);
        if(orderDetails==null){
            throw new LeadNewsException(ManagerCodeEnum.PARAM_INVALID);
        }
        //获取订单的商品id
        String goodsIds = orderDetails.getGoodsId();
        String[] split = goodsIds.split(",");

        List<OrderGoods> orderGoodsList = new ArrayList<>();
        for (String gid : split) {
            Integer goodsId = Integer.valueOf(gid);
            //根据商品id查询订单商品
            OrderGoods orderGoods = orderGoodsMapper.getOrderGoods(goodsId);
            orderGoodsList.add(orderGoods);
        }
        //数据转换
        List<OrderGoodsDto> orderGoodsDtoList = BeanHelper.copyWithCollection(orderGoodsList, OrderGoodsDto.class);

        OrderDetailsDto orderDetailsDto = BeanHelper.copyProperties(orderDetails, OrderDetailsDto.class);
        //设置订单中的商品信息
        orderDetailsDto.setGoodsList(orderGoodsDtoList);

        //根据订单id查询订单操作记录
        List<OrderOperation> operationList = orderOperationMapper.getOperation(id);
        if(CollectionUtils.isEmpty(operationList)){
            throw new LeadNewsException(ManagerCodeEnum.PARAM_INVALID);
        }

        //设置订单中的操作记录信息
        List<OrderOperationDto> orderOperationDtoList = BeanHelper.copyWithCollection(operationList, OrderOperationDto.class);
        orderDetailsDto.setOperationList(orderOperationDtoList);

        //返回订单详情信息
        return ResponseResult.okResult(orderDetailsDto);
    }
}
