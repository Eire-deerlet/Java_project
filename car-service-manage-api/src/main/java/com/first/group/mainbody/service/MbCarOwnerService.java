package com.first.group.mainbody.service;

import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.mainbody.dtos.CarOwnerDto;
import com.first.group.mainbody.vos.CarsVo;

import java.util.List;

public interface MbCarOwnerService {
    //  条件查询车主主体列表
    PageResponseResult findCarOwner(CarOwnerDto dto);
    //  锁定或解锁车主状态
    ResponseResult updateStatus(Integer id, Integer status);
    //  查询某位车主的所有车辆
    ResponseResult<List<CarsVo>> findCars(Integer carOwnerId);
}
