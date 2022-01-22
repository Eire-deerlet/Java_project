package com.first.group.prats.service;

import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.parts.dtos.BrandAddDto;
import com.first.group.parts.pojos.PcBrand;
import com.first.group.parts.pojos.PcPartsOne;

public interface PcBrandService {
    //查询品牌页面
    PageResponseResult list(Integer page, Integer pageSize);
    //新增品牌
    ResponseResult add(BrandAddDto dto);
    //修改品牌
    ResponseResult update(BrandAddDto dto,Integer id);
    //修改回显
    ResponseResult<PcBrand> findbyid(Integer id);
    //删除品牌
    ResponseResult delete(Integer id);
    //搜索品牌
    ResponseResult<PcBrand> search(String name, Integer coding);
}
