package com.first.group.order.pojos;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderAccessories implements Serializable {

    /**
     * 订单编号
     */
    private Integer id;

    /**
     * 订单时间
     */
    private Date createTime;

    /**
     * 商家名称
     */
    private String store;

    /**
     * 商家电话
     */
    private String storeTelephone;

    /**
     * 客户名称
     */
    private String client;

    /**
     * 客户电话
     */
    private String cliTelephone;

    /**
     * 订单状态 1：待支付  2：待审核  3：已审核  4：待发货  5：已发货  6：正在配送  7：待签收
     *        8：已收货  9：已确认  10：已完成  11：退款已完成  0：待评价
     */
    private Short status;

    /**
     * 订单金额
     */
    private Double total;

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
