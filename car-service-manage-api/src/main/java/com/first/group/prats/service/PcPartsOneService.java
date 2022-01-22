package com.first.group.prats.service;

import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.parts.dtos.OneAddDto;
import com.first.group.parts.dtos.OneUpdateDto;
import com.first.group.parts.pojos.PcPartsOne;



public interface PcPartsOneService {

    PageResponseResult list(Integer page, Integer pageSize);
    //修改回显
    ResponseResult<PcPartsOne> findbyid(Integer id);
    //添加一级分类
    ResponseResult add(OneAddDto dto);
    //修改配件分类
    ResponseResult update(OneUpdateDto dto);
    //搜索查询
    ResponseResult<PcPartsOne> search(String name, Integer coding);
    //删除配件分类
    ResponseResult delete(Integer id);
}
