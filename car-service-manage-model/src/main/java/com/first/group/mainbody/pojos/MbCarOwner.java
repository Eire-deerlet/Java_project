package com.first.group.mainbody.pojos;

import lombok.Data;

import java.io.Serializable;

/**
 * 车主主体表
 */
@Data
public class MbCarOwner implements Serializable {
    private Integer id; // 自增id
    private String name;    // 车主名称
    private String phoneNumber; // 车主号码
    private String password;    // 用户密码
    private Integer status; // 锁定状态
}
