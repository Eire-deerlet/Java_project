package com.first.group.prats.service;

import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.parts.dtos.PartsEndFindDto;
import com.first.group.parts.dtos.PartsSearchDto;
import com.first.group.parts.pojos.PcParts;
import com.first.group.parts.pojos.PcPartsOne;

public interface PcPartsService {
    //配件目录页面查询
    PageResponseResult list(Integer page, Integer pageSize);
    //搜索查询
    ResponseResult<PcParts> search(PartsSearchDto dto);
    //查询配件详情
    ResponseResult<PcParts> findbyid(Integer id);
    //下架配件
    ResponseResult update_id(Integer id);
    //已下架配件目录查询
    PageResponseResult list_end(Integer page, Integer pageSize);
    //已下架详情查询
    ResponseResult<PartsEndFindDto> findbyidEnd(Integer id);
    //上架配件
    ResponseResult putaway(Integer id);
}
