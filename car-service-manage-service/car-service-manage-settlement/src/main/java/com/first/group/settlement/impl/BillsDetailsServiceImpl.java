package com.first.group.settlement.impl;

import com.first.group.comment.BeanHelper;
import com.first.group.dtos.ManagerCodeEnum;
import com.first.group.dtos.ResponseResult;
import com.first.group.exception.CarServiceException;
import com.first.group.settlement.dtos.BillsDetailDto;
import com.first.group.settlement.mapper.BillsDetailsMapper;
import com.first.group.settlement.pojos.SmBillsDetail;
import com.first.group.settlement.service.BillsDetailsService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BillsDetailsServiceImpl implements BillsDetailsService {

    @Autowired
    private BillsDetailsMapper billsDetailsMapper;

    /**
     * 通过id查询账单详情页
     * @param billId
     * @return
     */
    @Override
    public ResponseResult billsDetails(String billId) {
        if (StringUtils.isEmpty(billId)){
            throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);
        }
        // 通过id查询数据
        SmBillsDetail billsDetail = billsDetailsMapper.findDetailsById(billId);
        if (billsDetail == null){
            throw new CarServiceException(ManagerCodeEnum.DATA_NOT_EXIST);
        }

        BillsDetailDto dto = BeanHelper.copyProperties(billsDetail, BillsDetailDto.class);

        return ResponseResult.okResult(dto);
    }

}
