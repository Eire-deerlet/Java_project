package com.first.group.parts.controller;

import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.parts.dtos.OneAddDto;
import com.first.group.parts.dtos.OneUpdateDto;
import com.first.group.parts.dtos.PartsEndFindDto;
import com.first.group.parts.dtos.PartsSearchDto;
import com.first.group.parts.pojos.PcParts;
import com.first.group.parts.pojos.PcPartsOne;
import com.first.group.prats.service.PcPartsOneService;
import com.first.group.prats.service.PcPartsService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * 一级表控制器
 */
@RestController
@RequestMapping("/car/pc_parts")
public class PcPartsController {

    @Reference
    private PcPartsService partsService;


    /**
     * Path： /192.168.12.131/car/pc_parts/list
     * Method： GET
     * 配件目录页面查询
     */
    @GetMapping("list")
    public PageResponseResult list(@RequestParam(defaultValue = "1") Integer page,
                                   @RequestParam(defaultValue = "10") Integer pageSize ){

        return partsService.list(page,pageSize);
    }

    /**
     * Path： /192.168.12.131/car/pc_parts/search
     * Method： GET
     * 搜索查询
     */
    @GetMapping("/search")
    public ResponseResult<PcParts> search(@RequestBody PartsSearchDto dto){
        return partsService.search(dto);
    }


    /**
     * Path： /192.168.12.131/car/pc_parts/findbyid
     * Method： GET
     * 查询配件详情
     */
    @GetMapping("/{id}")
    public ResponseResult<PcParts> findbyid(@PathVariable("id") Integer id){
        return partsService.findbyid(id);
    }


    /**
     * 下架配件
     * Path： /192.168.12.131/car/pc_parts/update_id
     * Method： PUT
     */

    @PutMapping("/{id}")
    public ResponseResult update_id(@PathVariable("id") Integer id){
        return partsService.update_id(id);
    }


    /**
     * Path： /192.168.12.131/car/pc_parts/list_end
     * Method： GET
     * 已下架配件目录查询
     */
    @GetMapping("list_end")
    public PageResponseResult list_end(@RequestParam(defaultValue = "1") Integer page,
                                   @RequestParam(defaultValue = "10") Integer pageSize ){

        return partsService.list_end(page,pageSize);
    }
    /**
     * Path： /192.168.12.131/car/pc_parts_end/search_end
     * Method： GET
     * 已下架搜索查询
     */
    @GetMapping("/search_end")
    public ResponseResult<PcParts> search_end(@RequestBody PartsSearchDto dto){
        return partsService.search(dto);
    }

    /**
     * Path： /192.168.12.131/car/pc_parts_end/findbyidEnd
     * Method： GET
     * 已下架详情查询
     */

    @GetMapping("/findbyidEnd/{id}")
    public ResponseResult<PartsEndFindDto> findbyidEnd(@PathVariable("id") Integer id){
        return partsService.findbyidEnd(id);
    }


    /**
     * 上架配件
     * Path： /192.168.12.131/car/pc_parts_end/putaway
     * Method： PUT
     */

    @PutMapping("/putaway/{id}")
    public ResponseResult putaway(@PathVariable("id") Integer id){
        return partsService.putaway(id);
    }




}
