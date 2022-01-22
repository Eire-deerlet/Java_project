package com.first.group.parts.impl;

import com.first.group.dtos.ManagerCodeEnum;
import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.exception.CarServiceException;
import com.first.group.parts.dtos.BrandAddDto;
import com.first.group.parts.mapper.PcBrandMapper;
import com.first.group.parts.pojos.PcBrand;
import com.first.group.parts.pojos.PcParts;
import com.first.group.parts.pojos.PcPartsOne;
import com.first.group.prats.service.PcBrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Service
public class PcBrandServiceImpl implements PcBrandService {
    @Autowired
     private PcBrandMapper pcBrandMapper;
    @Override
    public PageResponseResult list(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);

        List<PcBrand> findlist = pcBrandMapper.findlist();



        PageInfo<PcBrand> pageInfo = new PageInfo<>(findlist);
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
    //新增品牌
    @Override
    public ResponseResult add(BrandAddDto dto) {
        //健壮性判断
        if (dto ==null ){
            throw new CarServiceException(ManagerCodeEnum.PARAM_REQUIRE);
        }
        PcBrand pcBrand = new PcBrand();

        pcBrand.setCoding(dto.getCoding());
        pcBrand.setName(dto.getName());
        pcBrand.setLogo(dto.getLogo());
        pcBrand.setSort(dto.getSort());
        pcBrand.setCreateTime(new Date());
        pcBrand.setUpdateTime(new Date());

        pcBrandMapper.add(pcBrand);


        return ResponseResult.okResult(1);
    }
    //修改品牌
    @Override
    public ResponseResult update(BrandAddDto dto,Integer id) {
        //健壮性判断
        if (dto ==null ){
            throw new CarServiceException(ManagerCodeEnum.PARAM_REQUIRE);
        }

        PcBrand pcBrand = new PcBrand();
        pcBrand.setId(id);

        pcBrand.setCoding(dto.getCoding());
        pcBrand.setName(dto.getName());
        pcBrand.setLogo(dto.getLogo());
        pcBrand.setUpdateTime(new Date());
        pcBrand.setSort(dto.getSort());



        pcBrandMapper.update(pcBrand);
        return ResponseResult.okResult("修改成功");
    }
    //修改回显
    @Override
    public ResponseResult<PcBrand> findbyid(Integer id) {
        PcBrand pcBrand = pcBrandMapper.findbyid(id);

        return ResponseResult.okResult(pcBrand);
    }
    //删除品牌
    @Override
    public ResponseResult delete(Integer id) {
        pcBrandMapper.delete(id);

        return ResponseResult.okResult("删除成功");
    }
    //搜索品牌
    @Override
    public ResponseResult<PcBrand> search(String name, Integer coding) {
        PcBrand brand = pcBrandMapper.search(name, coding);

        return ResponseResult.okResult(brand);
    }
}
