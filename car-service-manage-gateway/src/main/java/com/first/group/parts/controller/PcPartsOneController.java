package com.first.group.parts.controller;

import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.parts.dtos.OneAddDto;
import com.first.group.parts.dtos.OneUpdateDto;
import com.first.group.parts.pojos.PcPartsOne;
import com.first.group.prats.service.PcPartsOneService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;


/**
 * 一级表控制器
 */
@RestController
@RequestMapping("/car/pc_parts_one")
public class PcPartsOneController {

    @Reference
    private PcPartsOneService pcPartsOneService;


    /**
     * Path： /192.168.12.131/car/pc_parts_one/list
     * Method： GET
     */
    @GetMapping("list")
    public PageResponseResult list(@RequestParam(defaultValue = "1") Integer page,
                                   @RequestParam(defaultValue = "10") Integer pageSize ){

        return pcPartsOneService.list(page,pageSize);
    }
    /**
     * Path： /192.168.12.131/car/pc_parts_one/add
     * Method： POST
     * 添加一级分类
     */
    @PostMapping("/add")
    public ResponseResult add(@RequestBody OneAddDto dto){
        return pcPartsOneService.add(dto);
    }

    /**
     * Path： /192.168.12.131/car/pc_parts_one/update
     * Method： PUT
     * 修改配件分类
     */
    @PutMapping("/update")
    public ResponseResult update(@RequestBody OneUpdateDto dto){
        return pcPartsOneService.update(dto);
    }



    /**
     * Path： /192.168.12.131/car/pc_parts_one/findbyid
     * Method： GET
     * 修改回显
     */
    @GetMapping("/{id}")
    public ResponseResult<PcPartsOne> findbyid(@PathVariable("id") Integer id){
        return pcPartsOneService.findbyid(id);
    }

    /**
     * Path： /192.168.12.131/car/pc_parts_one/search
     * Method： GET
     * 搜索查询
     * 分类名称 分类编码
     */
    @GetMapping("/search")
    public ResponseResult<PcPartsOne> search(Integer coding,
           String name){
        return pcPartsOneService.search(name,coding);
    }
    /**
     * Path： /192.168.12.131/car/pc_parts_two/delete
     *删除配件分类
     * Method： DELETE
     */
    @DeleteMapping("/delete/{id}")
    public ResponseResult delete(@PathVariable("id")Integer id) {

        return pcPartsOneService.delete(id);
    }

}
