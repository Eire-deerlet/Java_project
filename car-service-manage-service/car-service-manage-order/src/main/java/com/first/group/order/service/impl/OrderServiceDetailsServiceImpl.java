package com.first.group.order.service.impl;

import com.first.group.comment.BeanHelper;
import com.first.group.dtos.ManagerCodeEnum;
import com.first.group.dtos.ResponseResult;
import com.first.group.exception.LeadNewsException;
import com.first.group.mapper.OrderServiceDetailsMapper;
import com.first.group.mapper.OrderServiceItemsMapper;
import com.first.group.mapper.OrderServiceOperationMapper;
import com.first.group.order.dtos.OrderServiceDetailsDto;
import com.first.group.order.dtos.OrderServiceItemsDto;
import com.first.group.order.dtos.OrderServiceOperationDto;
import com.first.group.order.pojos.OrderServiceDetails;
import com.first.group.order.pojos.OrderServiceItems;
import com.first.group.order.pojos.OrderServiceOperation;
import com.first.group.order.service.OrderServiceDetailsService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceDetailsServiceImpl implements OrderServiceDetailsService {

    @Autowired
    private OrderServiceDetailsMapper orderServiceDetailsMapper;
    @Autowired
    private OrderServiceItemsMapper orderServiceItemsMapper;
    @Autowired
    private OrderServiceOperationMapper orderServiceOperationMapper;

    @Override
    public ResponseResult<OrderServiceDetails> getDetails(Integer id) {
        if(id==null){
            throw new LeadNewsException(ManagerCodeEnum.PARAM_INVALID);
        }
        //查询服务订单详情表
        OrderServiceDetails orderServiceDetails = orderServiceDetailsMapper.getDetails(id);
        String detailsItemsId = orderServiceDetails.getItemsId();
        //获取订单中服务项目的id
        String[] split = detailsItemsId.split(",");

        //根据服务项目id查询订单中的项目信息
        List<OrderServiceItemsDto> orderServiceItemsDtoList = new ArrayList<>();
        for (String itemId : split) {
            Integer itemsId = Integer.valueOf(itemId);
            OrderServiceItems orderServiceItems = orderServiceItemsMapper.getServiceItems(itemsId);
            OrderServiceItemsDto orderServiceItemsDto = BeanHelper.copyProperties(orderServiceItems, OrderServiceItemsDto.class);
            orderServiceItemsDtoList.add(orderServiceItemsDto);
        }
        OrderServiceDetailsDto orderServiceDetailsDto = BeanHelper.copyProperties(orderServiceDetails, OrderServiceDetailsDto.class);
        //设置服务订单中的服务项目信息
        orderServiceDetailsDto.setOrderServiceItemsDtoList(orderServiceItemsDtoList);

        //根据订单id查询相关操作记录
        List<OrderServiceOperation> operationList = orderServiceOperationMapper.getOperation(id);
        List<OrderServiceOperationDto> serviceOperationDtoList = BeanHelper.copyWithCollection(operationList, OrderServiceOperationDto.class);
        //设置服务订单中的操作记录
        orderServiceDetailsDto.setOrderOperationDtoList(serviceOperationDtoList);

        return ResponseResult.okResult(orderServiceDetailsDto) ;
    }
}
