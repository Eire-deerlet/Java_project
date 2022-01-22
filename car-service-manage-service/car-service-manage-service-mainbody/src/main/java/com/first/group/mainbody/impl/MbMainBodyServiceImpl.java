package com.first.group.mainbody.impl;

import com.first.group.comment.BeanHelper;
import com.first.group.dtos.ManagerCodeEnum;
import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.exception.CarServiceException;
import com.first.group.mainbody.dtos.MainBodyDto;
import com.first.group.mainbody.dtos.MainCheckDto;
import com.first.group.mainbody.dtos.MainUserDto;
import com.first.group.mainbody.mapper.MbMainBodyMapper;
import com.first.group.mainbody.mapper.MbShopMapper;
import com.first.group.mainbody.pojos.MbMainBody;
import com.first.group.mainbody.pojos.MbMainUser;
import com.first.group.mainbody.service.MbMainBodyService;
import com.first.group.mainbody.vos.MainBodyVo;
import com.first.group.mainbody.vos.MainCheckVo;
import com.first.group.mainbody.vos.MainUserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MbMainBodyServiceImpl implements MbMainBodyService {
    @Autowired
    private MbMainBodyMapper mainBodyMapper;
    @Autowired
    private MbShopMapper shopMapper;

    // 条件查询主体列表
    @Override
    public PageResponseResult findMainBody(MainBodyDto dto) {
        // 参数校验
        if (dto == null) throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);

        // 页数未设定，默认访问首页
        if (dto.getPage() == null) dto.setPage(1);
        if (dto.getSize() == null) dto.setSize(15);

        // 参数过滤，设默认值
        if (dto.getId() == null) dto.setId(-1);
        if (dto.getShortName() == null) dto.setShortName("");
        if (dto.getType() == null) dto.setType((short) 0);
        if (dto.getStatus() == null) dto.setStatus((short) -1);
        if (dto.getDistrictId() == null) dto.setDistrictId(-1);

        // 分页条件查询
        PageHelper.startPage(dto.getPage(), dto.getSize());
        List<MbMainBody> mainBodyList = mainBodyMapper.findMainBody(dto);
        PageInfo<MbMainBody> bodyPageInfo = new PageInfo<>(mainBodyList);

        // 封装返回分页信息及对应数据
        PageResponseResult pageResult = new PageResponseResult(bodyPageInfo.getPageNum(), bodyPageInfo.getPageSize(), Math.toIntExact(bodyPageInfo.getTotal()));
        List<MainBodyVo> mainBodyVoList = BeanHelper.copyWithCollection(mainBodyList, MainBodyVo.class);
        pageResult.setData(mainBodyVoList);
        return pageResult;
    }

    // 创建主体用户管理员
    @Override
    public ResponseResult addAdmin(MainUserDto dto) {
        if (dto == null) throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);
        if (dto.getBodyId() == null || StringUtils.isEmpty(dto.getUsername()) || StringUtils.isEmpty(dto.getName()) || StringUtils.isEmpty(dto.getPassword()) || StringUtils.isEmpty(dto.getPhoneNumber())) {
            throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);
        }
        // 查询该主体是否已经有管理员，如果有，结束方法
        boolean isAdmin = mainBodyMapper.findAdminByBodyId(dto.getBodyId());
        if (isAdmin) throw new CarServiceException(ManagerCodeEnum.DATA_EXIST);

        // 往user表中存入管理员
        Integer row1 = mainBodyMapper.addAdmin(dto);
        // 修改body中的is_admin值
        Integer row2 = mainBodyMapper.updateIsAdmin(dto.getBodyId());
        if (row1 > 0 && row2 > 0) {
            return ResponseResult.okResult(ManagerCodeEnum.SUCCESS);
        }
        return ResponseResult.errorResult(ManagerCodeEnum.UPDATE_OPERATION_FAIL);
    }

    // 条件查询主体用户列表
    @Override
    public PageResponseResult findMainUser(MainUserDto dto) {
        if (dto == null) throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);

        // 页数未设定，默认访问首页
        if (dto.getPage() == null) dto.setPage(1);
        if (dto.getSize() == null) dto.setSize(15);
        // 参数过滤，设默认值
        if (StringUtils.isEmpty(dto.getUsername())) dto.setUsername("");
        if (StringUtils.isEmpty(dto.getName())) dto.setName("");
        if (StringUtils.isEmpty(dto.getPhoneNumber())) dto.setPhoneNumber("");

        PageHelper.startPage(dto.getPage(), dto.getSize());
        List<MbMainUser> mainUserList = mainBodyMapper.findMainUser(dto);
        PageInfo<MbMainUser> userPageInfo = new PageInfo<>(mainUserList);

        PageResponseResult pageResult = new PageResponseResult(userPageInfo.getPageNum(), userPageInfo.getPageSize(), Math.toIntExact(userPageInfo.getTotal()));
        List<MainUserVo> mainUserVoList = BeanHelper.copyWithCollection(mainUserList, MainUserVo.class);
        pageResult.setData(mainUserVoList);
        return pageResult;
    }

    // 用户密码重置，默认为‘0616’
    @Override
    public ResponseResult remarkPassword(Integer id) {
        if (id == null) throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);
        Integer row = mainBodyMapper.remarkPassword(id);
        if (row > 0) {
            return ResponseResult.okResult(ManagerCodeEnum.SUCCESS);
        }
        return ResponseResult.errorResult(ManagerCodeEnum.UPDATE_OPERATION_FAIL);
    }

    // 修改主体用户锁定状态
    @Override
    public ResponseResult updateUserStatus(Integer id, Integer status) {
        Integer row = mainBodyMapper.updateUserStatus(id, status);
        if (row > 0) {
            return ResponseResult.okResult(ManagerCodeEnum.SUCCESS);
        }
        return ResponseResult.errorResult(ManagerCodeEnum.UPDATE_OPERATION_FAIL);
    }

    // 条件查询需要审核的主体列表
    @Override
    public PageResponseResult findCheckBody(MainCheckDto dto) {
        // 参数校验
        if (dto == null) throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);

        // 页数未设定，默认访问首页
        if (dto.getPage() == null) dto.setPage(1);
        if (dto.getSize() == null) dto.setSize(15);

        // 参数过滤，设默认值
        if (dto.getId() == null) dto.setId(-1);
        if (dto.getShortName() == null) dto.setShortName("");
        if (dto.getType() == null) dto.setType((short) 0);
        if (dto.getDistrictId() == null) dto.setDistrictId(-1);

        // 分页条件查询
        PageHelper.startPage(dto.getPage(), dto.getSize());
        List<MbMainBody> mainBodyList = mainBodyMapper.findCheckBody(dto);
        PageInfo<MbMainBody> bodyPageInfo = new PageInfo<>(mainBodyList);

        // 封装返回分页信息及对应数据
        PageResponseResult pageResult = new PageResponseResult(bodyPageInfo.getPageNum(), bodyPageInfo.getPageSize(), Math.toIntExact(bodyPageInfo.getTotal()));
        List<MainCheckVo> mainCheckVoList = BeanHelper.copyWithCollection(mainBodyList, MainCheckVo.class);
        pageResult.setData(mainCheckVoList);
        return pageResult;
    }

    // 主体通过审核或拒绝通过  审核    0，未审核(未审核，不会传进来）   1，通过    2，拒绝
    @Override
    public ResponseResult isPassBody(Integer shopId, Integer isPass) {
        if (shopId <= 0 || isPass > 2 || isPass < 0) throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);
        // 将审核结果修改进主体表审核is_check字段
        Integer row1 = mainBodyMapper.isPassBody(shopId, isPass);
        Integer row2 = 0;
        if (isPass == 1) {  // 通过了，将“通过”同步保存到商户表
            row2 = shopMapper.updateIsPassById(shopId, isPass);
        } else {    // 不通过，将商户表上的对应数据删除
            row2 = shopMapper.deleteShopById(shopId);
        }
        if (row1 > 0 && row2 > 0) {
            return ResponseResult.okResult(ManagerCodeEnum.SUCCESS);
        }
        return ResponseResult.errorResult(ManagerCodeEnum.UPDATE_OPERATION_FAIL);
    }

    // 条件查询审核被拒绝的主体列表
    @Override
    public PageResponseResult findRefuseBody(MainCheckDto dto) {
        // 参数校验
        if (dto == null) throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);

        // 页数未设定，默认访问首页
        if (dto.getPage() == null) dto.setPage(1);
        if (dto.getSize() == null) dto.setSize(15);

        // 参数过滤，设默认值
        if (dto.getId() == null) dto.setId(-1);
        if (dto.getShortName() == null) dto.setShortName("");
        if (dto.getType() == null) dto.setType((short) 0);
        if (dto.getDistrictId() == null) dto.setDistrictId(-1);

        // 分页条件查询
        PageHelper.startPage(dto.getPage(), dto.getSize());
        List<MbMainBody> mainBodyList = mainBodyMapper.findRefuseBody(dto);
        PageInfo<MbMainBody> bodyPageInfo = new PageInfo<>(mainBodyList);

        // 封装返回分页信息及对应数据
        PageResponseResult pageResult = new PageResponseResult(bodyPageInfo.getPageNum(), bodyPageInfo.getPageSize(), Math.toIntExact(bodyPageInfo.getTotal()));
        List<MainCheckVo> mainCheckVoList = BeanHelper.copyWithCollection(mainBodyList, MainCheckVo.class);
        pageResult.setData(mainCheckVoList);
        return pageResult;
    }
}
