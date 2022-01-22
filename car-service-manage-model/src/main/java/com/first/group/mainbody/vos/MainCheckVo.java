package com.first.group.mainbody.vos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MainCheckVo implements Serializable {

    /**
     * 自增主键,商户编码
     */
    private Integer id;

    /**
     * 简称
     */
    private String shortName;
    
    /**
     * 主体类型
     */
    private Short type;

    /**
     * 所属区域id
     */
    private Integer districtId;

    /**
     * 注册时间
     */
    private Date registerTime;

    /**
     * 来源
     */
    private String source;

    /**
     * 审核
     */
    private Integer isCheck;

}
