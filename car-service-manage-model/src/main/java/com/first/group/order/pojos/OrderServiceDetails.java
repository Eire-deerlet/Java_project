package com.first.group.order.pojos;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderServiceDetails implements Serializable {

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
     * 服务项目id
     */
    private String itemsId;

    //状态枚举类
    @Alias("OrderServiceDetailsStatus")
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
