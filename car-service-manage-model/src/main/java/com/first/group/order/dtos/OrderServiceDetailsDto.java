package com.first.group.order.dtos;

import com.first.group.order.pojos.OrderServiceItems;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class OrderServiceDetailsDto implements Serializable {

    /**
     * id
     */
    private  Integer id;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 订单时间
     */
    private Date createTime;

    /**
     * 订单状态
     */
    private Short status;

    /**
     * 车主
     */
    private String carOwner;

    /**
     * 车主联系电话
     */
    private String ownerTelephone;

    /**
     * 预约时间
     */
    private Date appointmentTime;

    /**
     * 车牌号
     */
    private String carNum;

    /**
     * 发动机号
     */
    private String engineNum;

    /**
     * VIN码
     */
    private String VINNum;

    /**
     * 车型
     */
    private String carType;

    /**
     * 汽修厂名称
     */
    private String factory;

    /**
     * 汽修厂联系电话
     */
    private String factoryTelephone;

    /**
     * 地址
     */
    private String factoryAddress;

    /**
     * 服务项目
     */
    private List<OrderServiceItemsDto> orderServiceItemsDtoList;

    /**
     * 操作记录
     */
    private List<OrderServiceOperationDto> orderOperationDtoList;

}
