package com.first.group.order.pojos;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class OrderDetails implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     *订货单编号
     */
    private String orderNum;

    /**
     * 订单时间
     */
    private Date createTime;

    /**
     * 订单状态
     */
    private Short status;

    /**
     * 收货方名称
     */
    private String recName;

    /**
     * 收货行政区域
     */
    private String recArea;

    /**
     * 收货地址
     */
    private String recAddress;

    /**
     * 订货人
     */
    private String buyer;

    /**
     * 订货人联系电话
     */
    private String buyerTelephone;

    /**
     * 配送方式
     */
    private String delivery;

    /**
     * 支付方式
     */
    private String pay;

    /**
     * 发货方名称
     */
    private String sentName;

    /**
     * 发货方行政区域
     */
    private String sentArea;

    /**
     * 发货地址
     */
    private String sentAddress;

    /**
     * 联系电话
     */
    private String sentTelephone;

    /**
     * 订单商品
     */
    private String goodsId;


    //状态枚举类
    @Alias("OrderAccessoriesStatus")
    public enum Status{
        TOBE_PAYED((short)1),TOBE_AUDITED((short)2),AUDITED((short)3),TOBE_DELIVERED((short)4),
        DELIVERED((short)5),DELIVERING((short)6),TOBE_SIGNED_IN((short)7),RECEIVED((short) 8),
        CONFIRM((short)9),DONE((short)10),REFUNDED((short)11),TOBE_COMMENT((short)0);
        short code;
        Status(short code){
            this.code = code;
        }
        public short getCode(){
            return this.code;
        }
    }
}
