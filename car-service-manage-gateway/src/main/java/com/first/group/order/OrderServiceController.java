package com.first.group.order;

import com.first.group.dtos.ResponseResult;
import com.first.group.order.dtos.CloseOrderDto;
import com.first.group.order.dtos.OrderServiceDto;
import com.first.group.order.pojos.OrderServiceDetails;
import com.first.group.order.service.OrderServiceDetailsService;
import com.first.group.order.service.OrderServiceService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class OrderServiceController {

    @Reference
    private OrderServiceService orderServiceService;
    @Reference
    private OrderServiceDetailsService orderServiceDetailsService;

    /**
     * 查询服务订单（除1以外的其他状态）/待处理订单（状态1）
     * 接口路径 POST /service/getOrderService
     * @param dto
     * @return
     */
    @PostMapping("/getOrderService")
    public ResponseResult<List<OrderServiceDto>> getOrderService(@RequestBody OrderServiceDto dto){
        return orderServiceService.getOrderService(dto);
    }

    /**
     * 查看服务订单详情
     * 接口路径 GET /service/getDetails/{id}
     * @param id
     * @return
     */
    @GetMapping("/getDetails/{id}")
    public ResponseResult<OrderServiceDetails> getDetails(@PathVariable("id") Integer id){
        return orderServiceDetailsService.getDetails(id);
    }

    @PostMapping("/closeOrder")
    public ResponseResult closeOrder(@RequestBody CloseOrderDto dto){
        return orderServiceService.closeOrder(dto);
    }
}
