package com.first.group.order.pojos;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderServiceOperation implements Serializable {

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

    //状态枚举类
    @Alias("OrderServiceOperationStatus")
    public enum Status{
        TOBE_ACCEPTED((short)1),ACCEPTED((short)2),TOBE_SERVED((short)3),START_SERVE((short)4),SERVING((short)5),
        SERVE_DONE((short) 6),DONE((short)7),TOBE_COMMENT((short)8);
        short code;
        Status(short code){
            this.code = code;
        }
        public short getCode(){
            return this.code;
        }
    }
}
