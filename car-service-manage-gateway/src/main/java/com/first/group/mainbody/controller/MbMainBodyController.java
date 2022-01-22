package com.first.group.mainbody.controller;

import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.mainbody.dtos.MainBodyDto;
import com.first.group.mainbody.dtos.MainCheckDto;
import com.first.group.mainbody.dtos.MainUserDto;
import com.first.group.mainbody.service.MbMainBodyService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mb_main_body")
public class MbMainBodyController {

    @Reference
    public MbMainBodyService mainBodyService;

    /**
     * 条件查询主体列表
     * POST /mb_main_body/findMainBody
     */
    @PostMapping("/findMainBody")
    public PageResponseResult findMainBody(@RequestBody MainBodyDto dto){
        return mainBodyService.findMainBody(dto);
    }

    /**
     * 创建主体用户管理员
     * POST /mb_main_body/addAdmin
     */
    @PostMapping("/addAdmin")
    public ResponseResult addAdmin(@RequestBody MainUserDto dto){
        return mainBodyService.addAdmin(dto);
    }

    /**
     * 条件查询主体用户列表
     * POST /mb_main_body/findMainUser
     */
    @PostMapping("/findMainUser")
    public PageResponseResult findMainUser(@RequestBody MainUserDto dto){
        return mainBodyService.findMainUser(dto);
    }

    /**
     * 用户密码重置
     * GET /mb_main_body/remarkPassword
     */
    @GetMapping("/remarkPassword")
    public ResponseResult remarkPassword(@RequestParam Integer id){
        return mainBodyService.remarkPassword(id);
    }

    /**
     * 修改主体用户锁定状态
     * GET /mb_main_body/updateStatus
     */
    @GetMapping("/updateUserStatus")
    public ResponseResult updateUserStatus(@RequestParam Integer id,
                                           @RequestParam Integer status){
        return mainBodyService.updateUserStatus(id, status);
    }

    /**
     * 条件查询需要审核的主体列表
     * POST /mb_main_body/findCheckBody
     */
    @PostMapping("/findCheckBody")
    public PageResponseResult findCheckBody(@RequestBody MainCheckDto dto){
        return mainBodyService.findCheckBody(dto);
    }

    /**
     * 主体通过审核或拒绝通过
     * GET /mb_main_body/isPassBody
     */
    @GetMapping("/isPassBody")
    public ResponseResult isPassBody(@RequestParam Integer shopId,
                                     @RequestParam Integer isPass){
        return mainBodyService.isPassBody(shopId, isPass);
    }

    /**
     * 条件查询审核被拒绝的主体列表
     * POST /mb_main_body/findCheckBody
     */
    @PostMapping("/findRefuseBody")
    public PageResponseResult findRefuseBody(@RequestBody MainCheckDto dto){
        return mainBodyService.findRefuseBody(dto);
    }
}
