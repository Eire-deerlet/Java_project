package com.first.group.parts.impl;

import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.parts.dtos.PartsEndFindDto;
import com.first.group.parts.dtos.PartsSearchDto;
import com.first.group.parts.mapper.PcPartsMapper;
import com.first.group.parts.pojos.PcParts;
import com.first.group.parts.pojos.PcPartsOne;
import com.first.group.prats.service.PcPartsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PcPartsServiceImpl implements PcPartsService {
    @Autowired
    private PcPartsMapper pcPartsMapper;
    @Override
    public PageResponseResult list(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);

        List<PcParts> findlist = pcPartsMapper.findlist();



        PageInfo<PcParts> pageInfo = new PageInfo<>(findlist);
        int pages = pageInfo.getPages();
        long total = pageInfo.getTotal();
        int num = pageInfo.getPageNum();
        int size = pageInfo.getSize();

        PageResponseResult responseResult = new PageResponseResult();
        responseResult.setCurrentPage(pages);
        responseResult.setSize(size);
        responseResult.setTotal((int) total);
        responseResult.setData(pageInfo.getList());

        return responseResult;

    }
    //搜索查询
    @Override
    public ResponseResult<PcParts> search(PartsSearchDto dto) {
        PcParts parts = pcPartsMapper.search(dto);

        return ResponseResult.okResult(parts);
    }
    //查询配件详情
    @Override
    public ResponseResult<PcParts> findbyid(Integer id) {
        PcParts parts = pcPartsMapper.findbyid(id);

        return ResponseResult.okResult(parts);
    }
    //下架配件
    @Override
    public ResponseResult update_id(Integer id) {
        pcPartsMapper.update(id);
        return ResponseResult.okResult("下架成功");
    }
    //已下架配件目录查询
    @Override
    public PageResponseResult list_end(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);

        List<PcParts> findlist = pcPartsMapper.findlistend();



        PageInfo<PcParts> pageInfo = new PageInfo<>(findlist);
        int pages = pageInfo.getPages();
        long total = pageInfo.getTotal();
        int num = pageInfo.getPageNum();
        int size = pageInfo.getSize();

        PageResponseResult responseResult = new PageResponseResult();
        responseResult.setCurrentPage(pages);
        responseResult.setSize(size);
        responseResult.setTotal((int) total);
        responseResult.setData(pageInfo.getList());

        return responseResult;
    }
    //已下架详情查询
    @Override
    public ResponseResult<PartsEndFindDto> findbyidEnd(Integer id) {
        PcParts parts = pcPartsMapper.findbyid(id);
        PartsEndFindDto endFindDto = new PartsEndFindDto();
        endFindDto.setType(parts.getType());
        endFindDto.setImage(parts.getImage());
        endFindDto.setDetail(parts.getDetail());

        return ResponseResult.okResult(endFindDto);
    }
    //上架配件
    @Override
    public ResponseResult putaway(Integer id) {
        pcPartsMapper.putaway(id);
        return ResponseResult.okResult("上架成功");
    }
}
