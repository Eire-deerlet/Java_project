package com.first.group.mainbody.pojos;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商户
 * 包括修车厂和配件商
 */
@Data
public class MbShop implements Serializable {
    private Integer id;         // 自增主键，汽修厂/配件商编码
    // private String shopNumber;
    private String fullName;    // 全称
    private String shortName;   // 简称
    private String contacts;    // 联系人
    private String contactNumber;   // 联系电话
    private Integer districtId; // 所在区域id
    private String address;     // 详细地址
    private Short chain;        // 是否连锁，0 否；1 是；
    private Short tag;          // 类型标签，0 无；1 一类；2 二类；3 三类；
    private BigDecimal lat;     // 纬度
    private BigDecimal lng;     // 经度
    private String images;      // 证件照（图片列表字符串）
    private Short status;       // 锁定状态，0 未锁；1 锁定；
    private Short type;         // 主体类型，1 汽修厂；2 配件商
    private Short isPass;      // 审核通过，0 尚未通过；1 通过
}
