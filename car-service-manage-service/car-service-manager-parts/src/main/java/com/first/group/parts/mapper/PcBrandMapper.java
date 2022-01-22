package com.first.group.parts.mapper;

import com.first.group.parts.pojos.PcBrand;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PcBrandMapper {

    List<PcBrand> findlist();

    void add(PcBrand pcBrand);
    //修改品牌
    void update(PcBrand pcBrand);
    //修改回显
    PcBrand findbyid(Integer id);
    //删除品牌
    void delete(Integer id);
    //搜索品牌
    PcBrand search(String name, Integer coding);
}
