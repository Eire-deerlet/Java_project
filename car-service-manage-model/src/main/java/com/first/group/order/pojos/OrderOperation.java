package com.first.group.order.pojos;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderOperation implements Serializable {
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
     * 状态
     */
    private Short status;

    /**
     * 操作人
     */
    private String name;

    //状态枚举类
    @Alias("OrderOperationStatus")
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
