package com.first.group.parts.controller;

import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.parts.dtos.OneAddDto;
import com.first.group.parts.dtos.OneTwoDto;
import com.first.group.parts.dtos.OneUpdateDto;
import com.first.group.parts.pojos.PcPartsOne;
import com.first.group.parts.pojos.PcPartsTwo;
import com.first.group.prats.service.PcPartsOneService;
import com.first.group.prats.service.PcPartsTwoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * 一级表控制器
 */
@RestController
@RequestMapping("/car/pc_parts_two")
public class PcPartsTwoController {

    @Reference
    private PcPartsTwoService twoService;


    /**
     * Path： /192.168.12.131/car/pc_parts_tow/list
     * Method： GET
     */
    @GetMapping("list")
    public PageResponseResult list(@RequestParam(defaultValue = "1") Integer page,
                                   @RequestParam(defaultValue = "10") Integer pageSize
                                   ){

        return twoService.list(page,pageSize);
    }

    /**
     *Path： /192.168.12.131/car/pc_parts_two/add
     * Method： POST
     * 添加二级分类
     */
    @PostMapping("/add")
    public ResponseResult add(@RequestBody OneTwoDto dto,Integer coding){
        return twoService.add(dto,coding);
    }


    /**
     * Path： /192.168.12.131/car/pc_parts_two/findbyid
     * Method： GET
     * 修改回显
     */
    @GetMapping("/{id}")
    public ResponseResult<PcPartsTwo> findbyid(@PathVariable("id") Integer id){
        return twoService.findbyid(id);
    }


    /**
     * Path： /192.168.12.131/car/pc_parts_two/update
     * Method： PUT
     * 修改二级分类
     */
    @PutMapping("/update")
    public ResponseResult update(@RequestBody OneTwoDto dto){
        return twoService.update(dto);
    }


    /**
     * Path： /192.168.12.131/car/pc_parts_two/delete
     * Method： DELETE
     * 删除二级分类
     */
    @DeleteMapping("/delete/{id}")
    public ResponseResult delete(@PathVariable("id")Integer id) {

        return twoService.delete(id);
    }



}
