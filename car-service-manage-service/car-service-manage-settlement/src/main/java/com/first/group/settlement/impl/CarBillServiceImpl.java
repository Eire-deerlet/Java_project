package com.first.group.settlement.impl;

import com.first.group.comment.BeanHelper;
import com.first.group.dtos.ManagerCodeEnum;
import com.first.group.dtos.PageResponseResult;
import com.first.group.dtos.ResponseResult;
import com.first.group.exception.CarServiceException;
import com.first.group.settlement.dtos.CarBillDto;
import com.first.group.settlement.dtos.SmBillDto;
import com.first.group.settlement.mapper.SmBillMapper;
import com.first.group.settlement.pojos.SmBill;
import com.first.group.settlement.service.CarBillService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CarBillServiceImpl implements CarBillService {

    @Autowired
    private SmBillMapper smBillMapper;

    /**
     * 车主账单首页列表
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
        List<SmBill> smBills = smBillMapper.findAll(dto);
        // 进行插件分页
        PageInfo<SmBill> pageInfo = new PageInfo<>(smBills);

        PageResponseResult pageResponseResult = new PageResponseResult();
        pageResponseResult.setCurrentPage(dto.getPage());  // 当前页
        pageResponseResult.setSize(dto.getSize()); // 页大小
        pageResponseResult.setTotal((int) pageInfo.getTotal()); // 总数量

        // 数据拷贝，展示需要的数据
        List<CarBillDto> carBillDtos = BeanHelper.copyWithCollection(pageInfo.getList(), CarBillDto.class);
        pageResponseResult.setData(carBillDtos);  // 当前页数据

        return pageResponseResult;
    }
}
