package com.first.group.parts.mapper;

import com.first.group.parts.pojos.PcPartsOne;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PcPartsOneMapper {

    /**
     * 查询所有一类表
     */
    List<PcPartsOne> findlist();


    //修改回显
    PcPartsOne findbyid(@Param("id") Integer id);


    //添加一级分类

   Integer  add(PcPartsOne pcPartsOne);
    //修改
    void update(PcPartsOne partsOne);
    //搜索查询
    PcPartsOne search(String name, Integer coding);
    //删除配件分类
    void delete(Integer id);
}
