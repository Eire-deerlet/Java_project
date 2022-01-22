package com.first.group.settlement.controller;

import com.first.group.dtos.ResponseResult;
import com.first.group.settlement.dtos.SmBillDto;
import com.first.group.settlement.service.CarBillService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 车主
 */
@RestController
@RequestMapping("settlement/car_bill")
public class CarBillController {

    @Reference(check = false)
    private CarBillService carBillService;

    /**
     * 查询首页车主账单
     * @param dto
     * @return
     */
    @GetMapping("list")
    public ResponseResult findAll(@RequestBody SmBillDto dto){
        return carBillService.findAll(dto);
    }
}

