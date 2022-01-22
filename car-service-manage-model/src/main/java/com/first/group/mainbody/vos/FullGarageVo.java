package com.first.group.mainbody.vos;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class FullGarageVo implements Serializable {
    private String fullName;    // 全称
    private String shortName;   // 简称
    private String contacts;        // 联系人
    private String contactNumber;   // 联系电话
    private Integer districtId; // 所在区域id
    private String address;     // 详细地址

    private Short chain;        // 是否连锁，0 否；1 是；
    private Short tag;          // 类型标签，0 无；1 一类；2 二类；3 三类；

    private BigDecimal lat;     // 纬度
    private BigDecimal lng;     // 经度
    private String images;      // 证件照（图片列表字符串）
}
