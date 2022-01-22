package com.first.group.mainbody.pojos;

import lombok.Data;

@Data
public class MbCarOwner {
    private Integer id; // 自增id
    private String name;    // 车主名称
    private String phoneNumber; // 车主号码
    private String password;    // 用户密码
    private Integer status; // 锁定状态
}
