package com.first.group.prats.service;

import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.parts.dtos.OneAddDto;
import com.first.group.parts.dtos.OneTwoDto;
import com.first.group.parts.dtos.OneUpdateDto;
import com.first.group.parts.pojos.PcPartsOne;
import com.first.group.parts.pojos.PcPartsTwo;

import java.util.List;

public interface PcPartsTwoService {

    PageResponseResult list(Integer page, Integer pageSize);
    //添加二级分类
    ResponseResult add(OneTwoDto dto,Integer coding);
    //修改回显
    ResponseResult<PcPartsTwo> findbyid(Integer id);
    //修改二级分类
    ResponseResult update(OneTwoDto dto);
    //删除二级分类
    ResponseResult delete(Integer id);
}
