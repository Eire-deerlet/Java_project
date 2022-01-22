package com.first.group.order;

import com.first.group.dtos.ResponseResult;
import com.first.group.order.dtos.OrderAccessoriesDto;
import com.first.group.order.dtos.OrderDetailsDto;
import com.first.group.order.service.OrderAccessoriesService;
import com.first.group.order.service.OrderDetailsService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderAccessoriesController {

    @Reference
    private OrderAccessoriesService orderAccessoriesService;

    @Reference
    private OrderDetailsService orderDetailsService;

    /**
     * 查询配件订单
     * 接口路径 POST /order/findList
     * @param dto
     * @return
     */
    @PostMapping("/findList")
    public ResponseResult<List<OrderAccessoriesDto>> findList(@RequestBody OrderAccessoriesDto dto){
        return orderAccessoriesService.findList(dto);
    }

    /**
     * 查看订单详情
     * 接口路径 GET /order/getDetails/{id}
     * @param id
     * @return
     */
    @GetMapping("/getOrderDetails/{id}")
    public ResponseResult<OrderDetailsDto> getDetails(@PathVariable("id") Integer id){
        return orderDetailsService.getDetails(id);
    }

}
