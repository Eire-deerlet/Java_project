package com.first.group.parts.mapper;

import com.first.group.parts.pojos.PcPartsTwo;

import java.util.List;

public interface PcPartsTwoMapper {


    List<PcPartsTwo> findlist();

    void add(PcPartsTwo partsTwo);
    //修改回显
    PcPartsTwo findbyid(Integer id);
    //修改二级分类
    void update(PcPartsTwo two);
    //删除二级分类
    void delete(Integer id);
}
