package com.first.group.order.dtos;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderServiceOperationDto implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 操作时间
     */
    private Date createTime;

    /**
     * 描述
     */
    private String description;

    /**
     * 订单状态
     */
    private Short status;

    /**
     * 操作人
     */
    private String name;

}
