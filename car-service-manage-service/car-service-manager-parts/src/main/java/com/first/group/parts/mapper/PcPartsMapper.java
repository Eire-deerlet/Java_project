package com.first.group.parts.mapper;

import com.first.group.parts.dtos.PartsSearchDto;
import com.first.group.parts.pojos.PcParts;

import java.util.List;

public interface PcPartsMapper {

    /**
     * 查询所有一类表
     */
    List<PcParts> findlist();
    //搜索查询
    PcParts search(PartsSearchDto dto);
    //查询配件详情
    PcParts findbyid(Integer id);
    //下架配件
    void update(Integer id);
    //已下架配件目录查询
    List<PcParts> findlistend();
    //上架配件
    void putaway(Integer id);
}
