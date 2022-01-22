package com.first.group.mainbody.impl;
import java.util.Date;

import com.first.group.comment.BeanHelper;
import com.first.group.dtos.ManagerCodeEnum;
import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.exception.CarServiceException;
import com.first.group.mainbody.dtos.*;
import com.first.group.mainbody.mapper.MbMainBodyMapper;
import com.first.group.mainbody.mapper.MbShopMapper;
import com.first.group.mainbody.pojos.MbMainBody;
import com.first.group.mainbody.pojos.MbShop;
import com.first.group.mainbody.service.MbShopService;
import com.first.group.mainbody.vos.FullGarageVo;
import com.first.group.mainbody.vos.FullPartsVo;
import com.first.group.mainbody.vos.ShortShopVo;
import com.first.group.minio.MinIOFileStorageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class MbShopServiceImpl implements MbShopService {
    @Autowired
    private MbShopMapper shopMapper;
    @Autowired
    private MinIOFileStorageService minIOFileStorageService;
    @Autowired
    private MbMainBodyMapper mainBodyMapper;

    // 查询商户（汽修厂+配件厂）简页列表
    @Override
    public PageResponseResult findShortShop(ShortShopDto dto) {
        // dto中的主体类型不可为空
        if (dto.getType() == null) throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);
        Short type = dto.getType();

        // 页数未设定，默认访问首页
        if (dto.getPage() == null) dto.setPage(1);
        if (dto.getSize() == null) dto.setSize(15);

        // 参数未设置，给与默认值
        if (dto.getId() == null) dto.setId(-1);
        if (dto.getShortName() == null) dto.setShortName("");
        if (dto.getContacts() == null) dto.setContacts("");
        if (dto.getContactNumber() == null) dto.setContactNumber("");
        if (dto.getDistrictId() == null) dto.setDistrictId(-1);
        if (dto.getChain() == null) dto.setChain((short) -1);
        if (dto.getStatus() == null) dto.setStatus((short) -1);

        PageHelper.startPage(dto.getPage(), dto.getSize());
        List<MbShop> stopList = shopMapper.findShortShop(dto);
        PageInfo<MbShop> stopPageInfo = new PageInfo<>(stopList);

        PageResponseResult pageResult = new PageResponseResult(stopPageInfo.getPageNum(), stopPageInfo.getPageSize(), Math.toIntExact(stopPageInfo.getTotal()));
        List<ShortShopVo> resultList = BeanHelper.copyWithCollection(stopList, ShortShopVo.class);
        pageResult.setData(resultList);

        return pageResult;
    }

    // 锁定或解锁商户,同时锁定主体
    @Override
    public ResponseResult updateStatus(Integer id, Integer status) {
        Integer row1 = shopMapper.updateStatus(id, status);
        Integer row2 = mainBodyMapper.updateBodyStatus(id, status);
        if (row1>0 && row2>0){
            return ResponseResult.okResult(ManagerCodeEnum.SUCCESS);
        }
        return ResponseResult.errorResult(ManagerCodeEnum.UPDATE_OPERATION_FAIL);
    }

    // 商户相关证件照上传
    @Override
    public ResponseResult<String> uploadCredentials(byte[] buffer, String extName) {
        // 文件不为空
        if (StringUtils.isEmpty(extName)) throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);

        // 上传到Minio,生成url返回给前端
        // 生成随机文件名
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        // 新的文件名
        String fileName = uuid + extName;
        InputStream inputStream = new ByteArrayInputStream(buffer);
        try {
            // 上传到Minio，获取图片地址
            String url = minIOFileStorageService.uploadImgFile("", fileName, inputStream);
            return ResponseResult.okResult(url);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CarServiceException(ManagerCodeEnum.FILE_UPLOAD_ERROR);
        }
    }

    // 点击编辑汽修厂时,回显基本信息
    @Override
    public ResponseResult<FullGarageVo> findGarageById(Integer id) {
        if (id == null) throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);
        // 根据id查询商户
        MbShop mbShop = shopMapper.findShopById(id);
        if (mbShop == null) throw new CarServiceException(ManagerCodeEnum.DATA_NOT_EXIST);
        // 封装数据，进行返回
        FullGarageVo fullGarageVo = BeanHelper.copyProperties(mbShop, FullGarageVo.class);
        return ResponseResult.okResult(fullGarageVo);
    }

    // 点击编辑配件商时,回显基本信息
    @Override
    public ResponseResult<FullPartsVo> findPartsById(Integer id) {
        if (id == null) throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);
        // 根据id查询商户
        MbShop mbShop = shopMapper.findShopById(id);
        if (mbShop == null) throw new CarServiceException(ManagerCodeEnum.DATA_NOT_EXIST);
        // 封装数据，进行返回
        FullPartsVo fullPartsVo = BeanHelper.copyProperties(mbShop, FullPartsVo.class);
        return ResponseResult.okResult(fullPartsVo);
    }

    // 新增和修改汽修厂基础信息,并同步数据到主体表，待审核
    @Override
    public ResponseResult addSaveGarage(FullShopDto dto) {
        if (dto == null) throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);
        Integer row1 = 0;
        Integer row2 = 0;
        MbShop shop = BeanHelper.copyProperties(dto, MbShop.class);

        if (dto.getId() == null) {  // 没有主键Id说明是新增
            shop.setStatus((short) 0);
            shop.setType((short) 1);
            shop.setIsPass((short) 0);
            row1 = shopMapper.addShop(shop);

            // 同步数据到主体表
            MbMainBody mainBody = new MbMainBody();
            mainBody.setShopId(shop.getId());
            mainBody.setShortName(shop.getShortName());
            mainBody.setType(shop.getType());
            mainBody.setStatus((short)0);
            mainBody.setDistrictId(shop.getDistrictId());
            mainBody.setIsAdmin((short)0);
            mainBody.setRegisterTime(new Date());
            mainBody.setSource("后台添加");
            mainBody.setIsCheck(0);
            row2 = mainBodyMapper.addMainBody(mainBody);
        } else {                    // 反之，说明只是修改
            row1 = shopMapper.saveGarage(shop);

            // 同步数据到主体表
            MbMainBody mainBody = new MbMainBody();
            mainBody.setShopId(shop.getId());
            mainBody.setShortName(shop.getShortName());
            mainBody.setDistrictId(shop.getDistrictId());
            row2 = mainBodyMapper.putMainBody(mainBody);
        }
        if (row1>0 && row2>0){
            return ResponseResult.okResult(ManagerCodeEnum.SUCCESS);
        }
        return ResponseResult.errorResult(ManagerCodeEnum.UPDATE_OPERATION_FAIL);
    }

    // 新增和修改配件商基础信息,并同步数据到主体表，待审核
    @Override
    public ResponseResult addSaveParts(FullShopDto dto) {
        if (dto == null) throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);
        Integer row1 = 0;
        Integer row2 = 0;
        MbShop shop = BeanHelper.copyProperties(dto, MbShop.class);
        if (dto.getId() == null) {  // 没有主键Id说明是新增
            shop.setChain((short) 0);
            shop.setTag((short) 0);
            shop.setLat(BigDecimal.valueOf(0));
            shop.setLng(BigDecimal.valueOf(0));
            shop.setStatus((short) 0);
            shop.setType((short) 2);
            shop.setIsPass((short) 0);
            row1 = shopMapper.addShop(shop);

            // 同步数据到主体表
            MbMainBody mainBody = new MbMainBody();
            mainBody.setShopId(shop.getId());
            mainBody.setShortName(shop.getShortName());
            mainBody.setType(shop.getType());
            mainBody.setStatus((short)0);
            mainBody.setDistrictId(shop.getDistrictId());
            mainBody.setIsAdmin((short)0);
            mainBody.setRegisterTime(new Date());
            mainBody.setSource("后台添加");
            mainBody.setIsCheck(0);
            row2 = mainBodyMapper.addMainBody(mainBody);
        }else {                    // 反之，说明只是修改
            row1 = shopMapper.saveParts(shop);

            // 同步数据到主体表
            MbMainBody mainBody = new MbMainBody();
            mainBody.setShopId(shop.getId());
            mainBody.setShortName(shop.getShortName());
            mainBody.setDistrictId(shop.getDistrictId());
            row2 = mainBodyMapper.putMainBody(mainBody);
        }
        if (row1>0 && row2>0){
            return ResponseResult.okResult(ManagerCodeEnum.SUCCESS);
        }
        return ResponseResult.errorResult(ManagerCodeEnum.UPDATE_OPERATION_FAIL);
    }
}
