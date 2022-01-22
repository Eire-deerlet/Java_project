package com.first.group.mainbody.impl;

import com.first.group.comment.BeanHelper;
import com.first.group.dtos.ManagerCodeEnum;
import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.exception.CarServiceException;
import com.first.group.mainbody.dtos.CarOwnerDto;
import com.first.group.mainbody.vos.CarOwnerVo;
import com.first.group.mainbody.vos.CarsVo;
import com.first.group.mainbody.mapper.MbCarOwnerMapper;
import com.first.group.mainbody.pojos.MbCarOwner;
import com.first.group.mainbody.pojos.MbCars;
import com.first.group.mainbody.service.MbCarOwnerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MbCarOwnerServiceImpl implements MbCarOwnerService {

    @Autowired
    private MbCarOwnerMapper carOwnerMapper;

    /**
     * 条件查询车主主体列表
     * @param dto
     * @return
     */
    @Override
    public PageResponseResult findCarOwner(CarOwnerDto dto) {
        // if (dto == null) throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);
        if (dto.getPage() == null)dto.setPage(1);
        if (dto.getSize() == null)dto.setSize(15);
        if (dto.getName() == null)dto.setName("");
        if (dto.getPhoneNumber() == null)dto.setPhoneNumber("");

        // 分页插件处理
        PageHelper.startPage(dto.getPage(),dto.getSize());

        // sql语句查询符合条件的车主
        List<MbCarOwner> mbCarOwnerList = carOwnerMapper.findCarOwner(dto);
        if (CollectionUtils.isEmpty(mbCarOwnerList)){   // 角色列表不存在！
            throw new CarServiceException(ManagerCodeEnum.ROLE_NOT_FOUND);
        }

        PageInfo<MbCarOwner> carOwnerVoPageInfo = new PageInfo<>(mbCarOwnerList);

        PageResponseResult pageResult = new PageResponseResult(carOwnerVoPageInfo.getPageNum(), carOwnerVoPageInfo.getPageSize(), Math.toIntExact(carOwnerVoPageInfo.getTotal()));

        // 将结果转换成Vo类型
        List<CarOwnerVo> carOwnerVoList = BeanHelper.copyWithCollection(mbCarOwnerList, CarOwnerVo.class);
        pageResult.setData(carOwnerVoList);
        return pageResult;
    }

    /**
     * 锁定或解锁车主状态
     * @param status
     * @return
     */
    @Override
    public ResponseResult updateStatus(Integer id, Integer status) {
        Integer row = carOwnerMapper.updateStatus(id, status);
        if (row>0){
            return ResponseResult.okResult(ManagerCodeEnum.SUCCESS);
        }
        return ResponseResult.errorResult(ManagerCodeEnum.UPDATE_OPERATION_FAIL);
    }

    /**
     * 查询某位车主的所有车辆
     * @param carOwnerId
     * @return
     */
    @Override
    public ResponseResult<List<CarsVo>> findCars(Integer carOwnerId) {
        List<MbCars> carsList = carOwnerMapper.findCars(carOwnerId);
        if (CollectionUtils.isEmpty(carsList)){
            throw new CarServiceException(ManagerCodeEnum.DATA_NOT_EXIST);
        }
        List<CarsVo> carsVoList = BeanHelper.copyWithCollection(carsList, CarsVo.class);
        return ResponseResult.okResult(carsVoList);
    }
}
