package com.first.group.settlement.impl;

import com.first.group.comment.BeanHelper;
import com.first.group.dtos.ManagerCodeEnum;
import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.exception.CarServiceException;
import com.first.group.settlement.dtos.*;
import com.first.group.settlement.mapper.ProviderBillMapper;
import com.first.group.settlement.mapper.SupplierBillMapper;
import com.first.group.settlement.pojos.SmBePay;
import com.first.group.settlement.pojos.SmBill;
import com.first.group.settlement.pojos.SmPay;
import com.first.group.settlement.service.SupplierBillService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SupplierBillServiceImpl implements SupplierBillService {

    @Autowired
    private SupplierBillMapper billMapper;

    /**
     * 查询服务商账单列表
     * @param dto
     * @return
     */
    @Override
    public ResponseResult findAll(SmBillDto dto) {
        if (dto == null){
            throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);
        }
        // 设置当前页与页面大小
        if (dto.getPage() == null)dto.setPage(1);
        if (dto.getSize() == null)dto.setSize(10);
        PageHelper.startPage(dto.getPage(),dto.getSize());

        // 获取指定条件数据
        List<SmBill> smBills = billMapper.findAll(dto);
        // 进行插件分页
        PageInfo<SmBill> pageInfo = new PageInfo<>(smBills);

        PageResponseResult pageResponseResult = new PageResponseResult();
        pageResponseResult.setCurrentPage(dto.getPage());  // 当前页
        pageResponseResult.setSize(dto.getSize()); // 页大小
        pageResponseResult.setTotal((int) pageInfo.getTotal()); // 总数量
        // 数据拷贝
        List<SupplierBillDto> billDtos = BeanHelper.copyWithCollection(pageInfo.getList(), SupplierBillDto.class);
        pageResponseResult.setData(billDtos);  // 当前页数据

        return pageResponseResult;
    }

    /**
     * 服务商待支付列表
     * @param dto
     * @return
     */
    @Override
    public ResponseResult supplierBePay(SupplierPayDto dto) {
        if (dto == null){
            throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);
        }
        // 设置当前页与页面大小
        if (dto.getPage() == null)dto.setPage(1);
        if (dto.getSize() == null)dto.setSize(10);
        PageHelper.startPage(dto.getPage(),dto.getSize());

        // 查询指定条件数据
        List<SmBePay> bills = billMapper.findBePay(dto);
        // 进行插件分页
        PageInfo<SmBePay> pageInfo = new PageInfo<>(bills);

        PageResponseResult pageResponseResult = new PageResponseResult();
        pageResponseResult.setCurrentPage(dto.getPage());  // 当前页
        pageResponseResult.setSize(dto.getSize()); // 页大小
        pageResponseResult.setTotal((int) pageInfo.getTotal()); // 总数量
        // 数据拷贝
        List<SmBePayDto> bePayDtos = BeanHelper.copyWithCollection(pageInfo.getList(), SmBePayDto.class);
        pageResponseResult.setData(bePayDtos);  // 当前页数据

        return pageResponseResult;

    }

    /**
     * 服务商支付列表
     * @param dto
     * @return
     */
    @Override
    public ResponseResult supplierPay(SupplierPayDto dto) {
        if (dto == null){
            throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);
        }
        // 设置当前页与页面大小
        if (dto.getPage() == null)dto.setPage(1);
        if (dto.getSize() == null)dto.setSize(10);
        PageHelper.startPage(dto.getPage(),dto.getSize());

        // 查询指定条件数据
        List<SmPay> bills = billMapper.findPay(dto);
        // 进行插件分页
        PageInfo<SmPay> pageInfo = new PageInfo<>(bills);

        PageResponseResult pageResponseResult = new PageResponseResult();
        pageResponseResult.setCurrentPage(dto.getPage());  // 当前页
        pageResponseResult.setSize(dto.getSize()); // 页大小
        pageResponseResult.setTotal((int) pageInfo.getTotal()); // 总数量
        // 数据拷贝
        List<SmPayDto> payDtos = BeanHelper.copyWithCollection(pageInfo.getList(), SmPayDto.class);
        pageResponseResult.setData(payDtos);  // 当前页数据

        return pageResponseResult;
    }
}
