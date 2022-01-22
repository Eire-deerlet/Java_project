package com.first.group.mainbody.service;

import com.first.group.dtos.PageResponseResult;
import com.first.group.mainbody.dtos.CarOwnerDto;

public interface MbCarOwnerService {
    public PageResponseResult findCarOwner(CarOwnerDto dto);
}
