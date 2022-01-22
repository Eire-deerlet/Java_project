package com.first.group.settlement.controller;


import com.first.group.dtos.ResponseResult;
import com.first.group.settlement.service.BillsDetailsService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("settlement/bill_details")
public class BillsDetailsController {

    @Reference(check = false)
    private BillsDetailsService billsDetailsService;

    /**
     * 查看账单详情页
     * @param billId
     * @return
     */
    @PostMapping("list")
    public ResponseResult billsDetails(String billId){
        return billsDetailsService.billsDetails(billId);
    }
}
