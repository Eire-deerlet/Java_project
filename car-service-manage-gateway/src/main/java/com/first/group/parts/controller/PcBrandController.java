package com.first.group.parts.controller;

import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.parts.dtos.BrandAddDto;
import com.first.group.parts.dtos.OneAddDto;
import com.first.group.parts.dtos.PartsEndFindDto;
import com.first.group.parts.dtos.PartsSearchDto;
import com.first.group.parts.pojos.PcBrand;
import com.first.group.parts.pojos.PcParts;
import com.first.group.parts.pojos.PcPartsOne;
import com.first.group.prats.service.PcBrandService;
import com.first.group.prats.service.PcPartsService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * 一级表控制器
 */
@RestController
@RequestMapping("/car/pc_brand")
public class PcBrandController {

    @Reference
    private PcBrandService brandService;


    /**
     * Path： /192.168.12.131/car/pc_brand/list
     * Method： GET
     * 查询品牌页面
     */
    @GetMapping("list")
    public PageResponseResult list(@RequestParam(defaultValue = "1") Integer page,
                                   @RequestParam(defaultValue = "10") Integer pageSize) {

        return brandService.list(page, pageSize);
    }

    /**
     * Path： /192.168.12.131/car/pc_brand/add
     * Method： POST
     * 新增品牌
     */
    @PostMapping("/add")
    public ResponseResult add(@RequestBody BrandAddDto dto) {
        return brandService.add(dto);
    }

    /**
     * Path： /192.168.12.131/car/pc_brand/update
     * Method： PUT
     * 修改品牌
     */
    @PutMapping("/update")
    public ResponseResult update(@RequestBody BrandAddDto dto, Integer id) {
        return brandService.update(dto, id);
    }


    /**
     * Path： /192.168.12.131/car/pc_brand/findbyid
     * Method： GET
     * 修改回显
     */
    @GetMapping("/{id}")
    public ResponseResult<PcBrand> findbyid(@PathVariable("id") Integer id) {
        return brandService.findbyid(id);
    }

    /**
     * Path： /192.168.12.131/car/pc_brand/delete
     * Method： DELETE
     * 删除品牌
     */

    @DeleteMapping("/delete/{id}")
    public ResponseResult delete(@PathVariable("id") Integer id) {

        return brandService.delete(id);
    }

    /**
     * Path： /192.168.12.131/car/pc_brand/search
     * Method： GET
     * 搜索品牌
     */
    @GetMapping("/search")
    public ResponseResult<PcBrand> search(String name ,Integer coding
                                             ){
        return brandService.search(name,coding);
    }






}