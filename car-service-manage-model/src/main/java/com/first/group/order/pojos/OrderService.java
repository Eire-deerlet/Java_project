package com.first.group.order.pojos;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderService implements Serializable {

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
     * 支付状态
     */
    private Short payStatus;

    /**
     * 订单状态
     */
    private Short status;

    /**
     * 订单金额
     */
    private Double total;

    /**
     * 订单是否超时未处理
     */
    private Short isTimeout;

    /**
     * 关闭订单
     */
    private Short isClosed;

    //支付状态枚举类
    @Alias("OrderServicePayStatus")
    public enum PayStatus{
        TOBE_PAYED((short)1),PAYED((short)0);
        short code;
        PayStatus(short code){
            this.code = code;
        }
        public short getCode(){
            return this.code;
        }
    }

    //状态枚举类
    @Alias("OrderServiceStatus")
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

    //订单超时未处理枚举类
    @Alias("OrderServicePayStatus")
    public enum isTimeout{
        IS_TIMEOUT((short)1),NOT_TIMEOUT((short)0);
        short code;
        isTimeout(short code){
            this.code = code;
        }
        public short getCode(){
            return this.code;
        }
    }
}
