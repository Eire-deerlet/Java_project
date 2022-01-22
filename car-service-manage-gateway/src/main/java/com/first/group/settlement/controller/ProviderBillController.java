package com.first.group.settlement.controller;

import com.first.group.dtos.ResponseResult;
import com.first.group.settlement.dtos.OrderPayDto;
import com.first.group.settlement.dtos.ProviderPayDto;
import com.first.group.settlement.dtos.SmBillDto;
import com.first.group.settlement.service.ProviderBillService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * 配件商
 */
@RestController
@RequestMapping("settlement/provider_bill")
public class ProviderBillController {

    @Reference
    private ProviderBillService providerBillService;

    /**
     * 查询配件商首页列表
     * @param dto
     * @return
     */
    @GetMapping("list")
    public ResponseResult findAll(@RequestBody SmBillDto dto){
        return providerBillService.findAll(dto);
    }

    /**
     * 配件商待支付列表
     * @param dto
     * @return
     */
    @PostMapping("be_pay")
    public ResponseResult providerBePay(@RequestBody ProviderPayDto dto){
        return providerBillService.providerBePay(dto);
    }

    /**
     * 配件商支付列表
     * @param dto
     * @return
     */
    @PostMapping("pay")
    public ResponseResult providerPay(@RequestBody ProviderPayDto dto){
        return providerBillService.providerPay(dto);
    }

    /**
     * 配件商需支付账单
     * @param merchantId
     * @return
     */
    @PostMapping("order_pay")
    public ResponseResult providerOrderPay(Integer merchantId){
        return providerBillService.providerOrderPay(merchantId);
    }

    /**
     * 查询需支付列表
     * @param dto
     * @return
     */
    @PostMapping("find_order_pay")
    public ResponseResult findOrderPay(@RequestBody OrderPayDto dto){
        return providerBillService.findOrderPay(dto);
    }
}
