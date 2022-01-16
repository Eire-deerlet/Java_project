package com.first.group.comment.pojos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

@Data
@Document("ap_fittings_comment")
public class APFittingsComment  implements Serializable {


    @Id
    private String id;


    /**
     * 预约单号
     */
    @Field("order_id")
    private Integer orderId;
    /**
     * 服务门店
     */
    @Field("store")
    private String store;


    /**
     * 订单时间
     */
    @Field("order_Time")
    private Date orderTime;
    /**
     * 客户名称
     */
    @Field(value = "userName")
    private String userName;
    /**
     * 评价得分1-10分
     */
    @Field(value = "appraise_score")
    private String appraiseScore;


    /**
     * 评价内容
     */
    @Field(value = "appraise_comment")
    private String appraiseComment;
    /**
     * 是否关闭评论  0开  1关
     */
    @Field(value = "status")
    private Integer status;

}
