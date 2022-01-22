package com.first.group.mainbody.vos;

import lombok.Data;

import java.io.Serializable;

@Data
public class MainBodyVo implements Serializable {
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
}
