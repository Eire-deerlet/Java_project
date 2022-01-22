package com.first.group.parts.impl;


import java.util.Date;

import com.first.group.dtos.ManagerCodeEnum;
import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.exception.CarServiceException;
import com.first.group.parts.dtos.OneAddDto;
import com.first.group.parts.dtos.OneUpdateDto;
import com.first.group.parts.mapper.PcPartsOneMapper;
import com.first.group.parts.pojos.PcPartsOne;
import com.first.group.prats.service.PcPartsOneService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PcPartsOneServiceImpl implements PcPartsOneService {
    @Autowired
    private PcPartsOneMapper oneMapper;

    @Override
    public PageResponseResult list(Integer page, Integer pageSize) {

        PageHelper.startPage(page,pageSize);

        List<PcPartsOne> findlist = oneMapper.findlist();



        PageInfo<PcPartsOne> pageInfo = new PageInfo<>(findlist);
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
    //修改回显
    @Override
    public ResponseResult<PcPartsOne> findbyid(Integer id) {
        PcPartsOne partsOne = oneMapper.findbyid(id);

        return ResponseResult.okResult(partsOne);
    }
    //添加一级分类
    @Override
    public ResponseResult add(OneAddDto dto) {
        //健壮性判断
        if (dto ==null ||dto.getCoding() ==null|| dto.getSort() ==null ||
                StringUtils.isEmpty(dto.getName())   || StringUtils.isEmpty(dto.getType())){
            throw new CarServiceException(ManagerCodeEnum.PARAM_REQUIRE);
        }

        PcPartsOne pcPartsOne = new PcPartsOne();
        pcPartsOne.setCoding(dto.getCoding());
        pcPartsOne.setName(dto.getName());
        pcPartsOne.setType(dto.getType());
        pcPartsOne.setState(0);
        pcPartsOne.setUpdateTime( new Date());
        pcPartsOne.setCreateTime( new Date());
        pcPartsOne.setSort(dto.getSort());

        oneMapper.add(pcPartsOne);


        return ResponseResult.okResult(1);
    }
    //修改配件分类
    @Override
    public ResponseResult update(OneUpdateDto dto) {
        //健壮性判断
        if (dto ==null ){
            throw new CarServiceException(ManagerCodeEnum.PARAM_REQUIRE);
        }

        PcPartsOne partsOne = new PcPartsOne();
        partsOne.setCoding(dto.getCoding());
        partsOne.setName(dto.getName());
        partsOne.setType(dto.getType());
        partsOne.setState(dto.getState());
        partsOne.setUpdateTime(new Date()); //修改时间
        partsOne.setSort(dto.getSort());

        oneMapper.update(partsOne);
     return ResponseResult.okResult("修改成功");

    }
    //搜索查询
    @Override
    public ResponseResult<PcPartsOne> search(String name, Integer coding) {
        PcPartsOne pcPartsOne = oneMapper.search(name, coding);

        return ResponseResult.okResult(pcPartsOne);
    }
    //删除配件分类
    @Override
    public ResponseResult delete(Integer id) {
       oneMapper.delete(id);

        return ResponseResult.okResult("删除成功");
    }


}
