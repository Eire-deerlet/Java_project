package com.first.group.settlement.impl;

import com.first.group.comment.BeanHelper;
import com.first.group.dtos.ManagerCodeEnum;
import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.exception.CarServiceException;
import com.first.group.settlement.dtos.*;
import com.first.group.settlement.mapper.OrderPayMapper;
import com.first.group.settlement.mapper.ProviderBillMapper;
import com.first.group.settlement.pojos.SmBill;
import com.first.group.settlement.pojos.SmBePay;
import com.first.group.settlement.pojos.SmOrderPay;
import com.first.group.settlement.pojos.SmPay;
import com.first.group.settlement.service.ProviderBillService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ProviderBillServiceImpl implements ProviderBillService {

    @Autowired
    private ProviderBillMapper billMapper;

    @Autowired
    private OrderPayMapper orderPayMapper;

    /**
     * 查询配件商首页列表
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
        List<ProviderBillDto> billDtos = BeanHelper.copyWithCollection(pageInfo.getList(), ProviderBillDto.class);
        pageResponseResult.setData(billDtos);  // 当前页数据

        return pageResponseResult;
    }

    /**
     * 配件商待支付列表
     * @param dto
     * @return
     */
    @Override
    public ResponseResult providerBePay(ProviderPayDto dto) {
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
     * 配件商支付列表
     * @param dto
     * @return
     */
    @Override
    public ResponseResult providerPay(ProviderPayDto dto) {
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

    /**
     * 配件商需支付账单
     * @param merchantId
     * @return
     */
    @Override
    public ResponseResult providerOrderPay(Integer merchantId) {
        if (merchantId == null){
            throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);
        }
        // 通过商家id查询需支付的账单
        List<SmOrderPay> smOrderPays = orderPayMapper.findByMerchantId(merchantId);
        if (CollectionUtils.isEmpty(smOrderPays)){
            throw new CarServiceException(ManagerCodeEnum.DATA_NOT_EXIST);
        }
        // 数据拷贝
        List<SmOrderPayDto> smOrderPayDtos = BeanHelper.copyWithCollection(smOrderPays, SmOrderPayDto.class);

        return ResponseResult.okResult(smOrderPayDtos);

    }

    /**
     * 查询需支付列表
     * @param dto
     * @return
     */
    @Override
    public ResponseResult findOrderPay(OrderPayDto dto) {
        if (dto == null){
            throw new CarServiceException(ManagerCodeEnum.PARAM_INVALID);
        }
        // 根据条件查询订单信息
        List<SmOrderPay> smOrderPays = orderPayMapper.findOrderPay(dto);
        if (CollectionUtils.isNotEmpty(smOrderPays)){
            // 数据拷贝
            List<SmOrderPayDto> smOrderPayDtos = BeanHelper.copyWithCollection(smOrderPays, SmOrderPayDto.class);

            return ResponseResult.okResult(smOrderPayDtos);
        }
        return null;
    }
}
