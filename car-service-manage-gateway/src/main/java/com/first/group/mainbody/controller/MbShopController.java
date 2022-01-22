package com.first.group.mainbody.controller;

import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.mainbody.vos.FullGarageVo;
import com.first.group.mainbody.vos.FullPartsVo;
import com.first.group.mainbody.dtos.FullShopDto;
import com.first.group.mainbody.dtos.ShortShopDto;
import com.first.group.mainbody.service.MbShopService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/mb_shop")
public class MbShopController {

    @Reference
    public MbShopService shopService;

    /**
     * 查询商户（汽修厂+配件厂）简页列表
     * POST /mb_shop/findShortStop
     */
    @PostMapping("/findShortShop")
    public PageResponseResult findShortShop(@RequestBody ShortShopDto dto){
         return shopService.findShortShop(dto);
    }

    /**
     * 锁定或解锁商户主体
     * GET /mb_shop/updateStatus
     */
    @GetMapping("/updateStatus")
    public ResponseResult updateStatus(@RequestParam Integer id,
                                       @RequestParam Integer status){
        return shopService.updateStatus(id, status);
    }

    /**
     * 商户相关证件照上传
     * POST /mb_shop/upload_credentials
     */
    @PostMapping("/upload_credentials")
    public ResponseResult<String> uploadCredentials(MultipartFile multipartFile) throws IOException {
        // 取出文件原名
        String originalFilename = multipartFile.getOriginalFilename();
        // 获取文件后缀名
        String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
        byte[] buffer = multipartFile.getBytes();
        return shopService.uploadCredentials(buffer, extName);
    }

    /**
     * 点击编辑汽修厂时,回显基本信息
     * GET /mb_shop/findGarageById
     */
    @GetMapping("/findGarageById")
    public ResponseResult<FullGarageVo> findGarageById(@RequestParam Integer id){
        return shopService.findGarageById(id);
    }

    /**
     * 点击编辑配件厂时,回显基本信息
     * GET /mb_shop/findPartsById
     */
    @GetMapping("/findPartsById")
    public ResponseResult<FullPartsVo> findPartsById(@RequestParam Integer id){
        return shopService.findPartsById(id);
    }

    /**
     * 新增和修改汽修厂基础信息
     * POST /mb_shop/addSaveGarage
     */
    @PostMapping("/addSaveGarage")
    public ResponseResult addSaveGarage(@RequestBody FullShopDto dto){
        return shopService.addSaveGarage(dto);
    }

    /**
     * 新增和修改配件商基础信息
     * POST /mb_shop/addSaveParts
     */
    @PostMapping("/addSaveParts")
    public ResponseResult addSaveParts(@RequestBody FullShopDto dto){
        return shopService.addSaveParts(dto);
    }
}
