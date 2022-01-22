package com.first.group.mainbody.pojos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MbMainBody implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 自增主键
    */
    private Integer id;

    /**
     * 商户编码
     */
    private Integer shopId;

    /**
    * 简称
    */
    private String shortName;

    /**
    * 主体类型
    */
    private Short type;

    /**
    * 锁定状态
    */
    private Short status;

    /**
    * 所属区域id
    */
    private Integer districtId;

    /**
     * 是否有管理员
     */
    private Short isAdmin;

    /**
    * 注册时间
    */
    private Date registerTime;

    /**
    * 来源
    */
    private String source;

    /**
    * 审核    0，未审核   1，通过    2，拒绝
    */
    private Integer isCheck;

}