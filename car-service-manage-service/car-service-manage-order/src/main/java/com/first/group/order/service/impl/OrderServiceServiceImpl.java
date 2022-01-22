package com.first.group.order.service.impl;

import com.first.group.comment.BeanHelper;
import com.first.group.dtos.ManagerCodeEnum;
import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.exception.LeadNewsException;
import com.first.group.mapper.OrderServiceMapper;
import com.first.group.order.dtos.CloseOrderDto;
import com.first.group.order.dtos.OrderServiceDto;
import com.first.group.order.pojos.OrderService;
import com.first.group.order.service.OrderServiceService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceServiceImpl implements OrderServiceService {

    @Autowired
    private OrderServiceMapper orderServiceMapper;

    @Override
    public ResponseResult<List<OrderServiceDto>> getOrderService(OrderServiceDto dto) {
        //查询所有服务订单
        List<OrderService> orderServices = orderServiceMapper.getAll();
        if(CollectionUtils.isEmpty(orderServices)){
            throw new LeadNewsException(400,"暂未查询到订单");
        }
        //校验参数
        if(dto.getStatus()==null)dto.setStatus((short)0);
        if(dto.getPageNum()==null)dto.setPageNum(1);
        if(dto.getPageSize()==null)dto.setPageSize(15);
        dto.setPageNum((dto.getPageNum()-1)* dto.getPageSize());

        //拼接查询条件，分页查询服务订单
        List<OrderService> orderServiceList = orderServiceMapper.getOrderService(dto);

        //数据转换，设置返回订单状态
        List<OrderServiceDto> orderServiceDtoList = orderServiceList.stream().map(orderService -> {
            OrderServiceDto orderServiceDto = BeanHelper.copyProperties(orderService, OrderServiceDto.class);
            if(!dto.getStatus().equals((short)0)) {
                orderServiceDto.setStatus(dto.getStatus());
            }
            if(dto.getStatus().equals((short)0)){
                if(orderService.getStatus().equals(OrderService.Status.TOBE_SERVED.getCode())){
                    orderServiceDto.setStatus(OrderService.Status.ACCEPTED.getCode());
                }
                if(orderService.getStatus().equals(OrderService.Status.TOBE_COMMENT.getCode())
                        ||orderService.getStatus().equals(OrderService.Status.START_SERVE.getCode())
                        ||orderService.getStatus().equals(OrderService.Status.SERVING.getCode())){
                    orderServiceDto.setStatus(OrderService.Status.SERVE_DONE.getCode());
                }
            }
            return orderServiceDto;
        }).collect(Collectors.toList());

        //返回分页查询结果
        PageResponseResult pageResponseResult = new PageResponseResult();
        pageResponseResult.setData(orderServiceDtoList);
        pageResponseResult.setCurrentPage(dto.getPageNum()/dto.getPageSize()+1);
        pageResponseResult.setSize(orderServiceDtoList.size());
        pageResponseResult.setTotal(orderServiceList.size());

        return pageResponseResult;
    }

    @Override
    public ResponseResult closeOrder(CloseOrderDto dto) {
        if(dto.getId()==null || dto.getIsClosed()==null){
            throw new LeadNewsException(ManagerCodeEnum.PARAM_INVALID);
        }
        OrderService orderService = orderServiceMapper.findById(dto.getId());
        if(orderService==null){
            throw new LeadNewsException(ManagerCodeEnum.PARAM_INVALID);
        }
        orderServiceMapper.closeOrder(dto);
        return ResponseResult.okResult(ManagerCodeEnum.SUCCESS);
    }
}
