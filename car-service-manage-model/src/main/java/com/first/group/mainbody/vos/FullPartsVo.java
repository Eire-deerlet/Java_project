package com.first.group.mainbody.vos;

import lombok.Data;

import java.io.Serializable;

@Data
public class FullPartsVo implements Serializable {
    private String fullName;    // 全称
    private String shortName;   // 简称
    private String contacts;        // 联系人
    private String contactNumber;   // 联系电话
    private Integer districtId; // 所在区域id
    private String address;     // 详细地址

    private String images;      // 证件照（图片列表字符串）
}
