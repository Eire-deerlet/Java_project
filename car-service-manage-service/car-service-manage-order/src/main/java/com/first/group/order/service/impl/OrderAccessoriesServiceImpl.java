package com.first.group.order.service.impl;

import com.first.group.comment.BeanHelper;
import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.exception.LeadNewsException;
import com.first.group.mapper.OrderAccessoriesMapper;
import com.first.group.order.dtos.OrderAccessoriesDto;
import com.first.group.order.pojos.OrderAccessories;
import com.first.group.order.service.OrderAccessoriesService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class OrderAccessoriesServiceImpl implements OrderAccessoriesService {

    @Autowired
    private OrderAccessoriesMapper orderAccessoriesMapper;

    @Override
    public ResponseResult<List<OrderAccessoriesDto>> findList(OrderAccessoriesDto dto) {
        //查询所有配件订单
        List<OrderAccessories> accessoriesList = orderAccessoriesMapper.findAll();
        if(CollectionUtils.isEmpty(accessoriesList)){
            throw new LeadNewsException(400,"暂未查询到订单");
        }
        //参数校验
        if(dto.getPageNum()==null)dto.setPageNum(1);
        if(dto.getPageSize()==null)dto.setPageSize(15);
        dto.setPageNum((dto.getPageNum()-1)* dto.getPageSize());
        //拼接查询条件，分页查询配件订单
        List<OrderAccessories> orderAccessoriesList = orderAccessoriesMapper.findList(dto);

        //数据装换
        List<OrderAccessoriesDto> orderAccessoriesDtoList = BeanHelper.copyWithCollection(orderAccessoriesList, OrderAccessoriesDto.class);

        //设置返回参数
        PageResponseResult pageResponseResult = new PageResponseResult();
        pageResponseResult.setData(orderAccessoriesDtoList);
        pageResponseResult.setCurrentPage(dto.getPageNum()/dto.getPageSize()+1);
        pageResponseResult.setSize(orderAccessoriesList.size());
        pageResponseResult.setTotal(accessoriesList.size());

        return pageResponseResult;
    }
}
