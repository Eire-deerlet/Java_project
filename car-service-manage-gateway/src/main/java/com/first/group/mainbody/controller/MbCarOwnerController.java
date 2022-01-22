package com.first.group.mainbody.controller;

import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.mainbody.dtos.CarOwnerDto;
import com.first.group.mainbody.vos.CarsVo;
import com.first.group.mainbody.service.MbCarOwnerService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mb_car")
public class MbCarOwnerController {

    @Reference
    private MbCarOwnerService carOwnerService;

    /**
     * 条件查询车主主体列表
     * POST /mb_car/findCarOwner
     */
    @PostMapping("/findCarOwner")
    public PageResponseResult findCarOwner(@RequestBody CarOwnerDto dto){
        return carOwnerService.findCarOwner(dto);
    }

    /**
     * 锁定或解锁车主状态
     * GET /mb_car/updateStatus
     */
    @GetMapping("/updateStatus")
    public ResponseResult updateStatus(@RequestParam Integer id,
                                       @RequestParam Integer status){
        return carOwnerService.updateStatus(id, status);
    }

    /**
     * 查询某位车主的所有车辆
     * GET /mb_car/findCars
     */
    @GetMapping("/findCars")
    public ResponseResult<List<CarsVo>> findCars(@RequestParam Integer carOwnerId){
        return carOwnerService.findCars(carOwnerId);
    }
}
