package com.first.group.mainbody.service;

import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.mainbody.vos.FullGarageVo;
import com.first.group.mainbody.vos.FullPartsVo;
import com.first.group.mainbody.dtos.FullShopDto;
import com.first.group.mainbody.dtos.ShortShopDto;

public interface MbShopService {
    // 查询商户（汽修厂+配件厂）简页列表
    PageResponseResult findShortShop(ShortShopDto dto);
    // 锁定或解锁商户主体
    ResponseResult updateStatus(Integer id, Integer status);
    // 商户相关证件照上传
    ResponseResult<String> uploadCredentials(byte[] buffer, String extName);
    // 点击编辑汽修厂时,回显基本信息
    ResponseResult<FullGarageVo> findGarageById(Integer id);
    // 点击编辑配件厂时,回显基本信息
    ResponseResult<FullPartsVo> findPartsById(Integer id);
    // 新增和修改汽修厂基础信息
    ResponseResult addSaveGarage(FullShopDto dto);
    // 新增和修改配件商基础信息
    ResponseResult addSaveParts(FullShopDto dto);

}
