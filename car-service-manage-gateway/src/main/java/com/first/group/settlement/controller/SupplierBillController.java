package com.first.group.settlement.controller;

import com.first.group.dtos.ResponseResult;
import com.first.group.settlement.dtos.SmBillDto;
import com.first.group.settlement.dtos.SupplierBillDto;
import com.first.group.settlement.dtos.SupplierPayDto;
import com.first.group.settlement.service.SupplierBillService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * 服务商
 */

@RestController
@RequestMapping("settlement/supplier_bill")
public class SupplierBillController {

    @Reference
    private SupplierBillService billService;

    /**
     * 查询服务商账单列表
     * @param dto
     * @return
     */
    @GetMapping("list")
    public ResponseResult findAll(@RequestBody SmBillDto dto){
        return billService.findAll(dto);
    }

    /**
     * 服务商待支付列表
     * @param dto
     * @return
     */
    @PostMapping("be_pay")
    public ResponseResult supplierBePay(@RequestBody SupplierPayDto dto){
        return billService.supplierBePay(dto);
    }

    /**
     * 服务商支付列表
     * @param dto
     * @return
     */
    @PostMapping("pay")
    public ResponseResult supplierPay(@RequestBody SupplierPayDto dto){
        return billService.supplierPay(dto);
    }
}
