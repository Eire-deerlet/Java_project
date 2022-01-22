package com.first.group.mainbody.service;

import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.mainbody.dtos.MainBodyDto;
import com.first.group.mainbody.dtos.MainCheckDto;
import com.first.group.mainbody.dtos.MainUserDto;

public interface MbMainBodyService {
    // 条件查询主体列表
    PageResponseResult findMainBody(MainBodyDto dto);
    // 创建主体用户管理员
    ResponseResult addAdmin(MainUserDto dto);
    // 条件查询主体用户列表
    PageResponseResult findMainUser(MainUserDto dto);
    // 用户密码重置
    ResponseResult remarkPassword(Integer id);
    // 修改主体用户锁定状态
    ResponseResult updateUserStatus(Integer id, Integer status);
    // 条件查询需要审核的主体列表
    PageResponseResult findCheckBody(MainCheckDto dto);
    // 主体通过审核或拒绝通过
    ResponseResult isPassBody(Integer id, Integer isPass);
    // 条件查询审核被拒绝的主体列表
    PageResponseResult findRefuseBody(MainCheckDto dto);
}
