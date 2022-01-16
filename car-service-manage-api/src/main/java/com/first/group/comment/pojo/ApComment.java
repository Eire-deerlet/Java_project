package com.first.group.comment.pojo;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;


@Data
@Document("ap_comment")
public class ApComment  implements Serializable {
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
    @Field("service_store")
    private String serviceStore;
    /**
     * 服务分类
     */
    @Field("service_classify")
    private String serviceClassify;


    /**
     * 订单时间
     */
    @Field("order_time")
    private Date orderTime;
    /**
     * 客户名称
     */
    @Field("user_name")
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
     * 图片
     */
    @Field("image")
    private String image;

    /**
     * 是否关闭评论  0开  1关
     */
    @Field(value = "status")
    private int status;

}
