package com.first.group.parts.impl;


import com.first.group.comment.ThreadLocalUtils;
import com.first.group.dtos.ManagerCodeEnum;
import com.first.group.dtos.PageResponseResult;

import com.first.group.dtos.ResponseResult;
import com.first.group.exception.CarServiceException;
import com.first.group.parts.dtos.OneTwoDto;
import com.first.group.parts.mapper.PcPartsOneMapper;
import com.first.group.parts.mapper.PcPartsTwoMapper;
import com.first.group.parts.pojos.PcPartsOne;
import com.first.group.parts.pojos.PcPartsTwo;
import com.first.group.prats.service.PcPartsTwoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.common.threadlocal.InternalThreadLocal;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Service
public class PcPartsTwoServiceImpl implements PcPartsTwoService {
    @Autowired
    private PcPartsTwoMapper twoMapper;
    @Autowired
    private PcPartsOneMapper oneMapper;


    @Override
    public PageResponseResult list(Integer page, Integer pageSize) {

        PageHelper.startPage(page,pageSize);

        List<PcPartsTwo> findlist = twoMapper.findlist();



        PageInfo<PcPartsTwo> pageInfo = new PageInfo<>(findlist);
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
    //添加二级分类
    @Override
    public ResponseResult add(OneTwoDto dto ,Integer coding) {
        //健壮性判断
        if (dto ==null ||dto.getCoding() ==null|| dto.getSort() ==null ||
                StringUtils.isEmpty(dto.getName())   || StringUtils.isEmpty(dto.getImage())){
            throw new CarServiceException(ManagerCodeEnum.PARAM_REQUIRE);
        }

       /* InternalThreadLocal threadLocal = new InternalThreadLocal();
        PcPartsOne pcPartsOne = (PcPartsOne) threadLocal.get();
        if(pcPartsOne==null){ //
            //没有子类
            return ResponseResult.okResult(null);
        }*/


        PcPartsTwo partsTwo = new PcPartsTwo();
        partsTwo.setCoding(dto.getCoding());
        partsTwo.setName(dto.getName());
        partsTwo.setImage(dto.getImage());
        partsTwo.setPartsOneCondig(coding);//一级分类编码
        partsTwo.setUpdateTime(new Date());
        partsTwo.setCreateTime(new Date());



        twoMapper.add(partsTwo);


        return ResponseResult.okResult(1);
    }
    //修改回显
    @Override
    public ResponseResult<PcPartsTwo> findbyid(Integer id) {
        PcPartsTwo two = twoMapper.findbyid(id);

        return ResponseResult.okResult(two);
    }
    //修改二级分类
    @Override
    public ResponseResult update(OneTwoDto dto) {
        //健壮性判断
        if (dto ==null ){
            throw new CarServiceException(ManagerCodeEnum.PARAM_REQUIRE);
        }
        PcPartsTwo two = new PcPartsTwo();
        two.setSort(dto.getSort());
        two.setCoding(dto.getCoding());
        two.setName(dto.getName());
        two.setImage(dto.getImage());
        two.setUpdateTime(new Date());

        twoMapper.update(two);
        return ResponseResult.okResult("修改成功");
    }
    //删除二级分类
    @Override
    public ResponseResult delete(Integer id) {
        twoMapper.delete(id);

        return ResponseResult.okResult("删除成功");
    }
}
