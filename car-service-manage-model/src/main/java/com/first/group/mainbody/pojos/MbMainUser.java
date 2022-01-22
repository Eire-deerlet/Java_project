package com.first.group.mainbody.pojos;

import lombok.Data;

import java.io.Serializable;

@Data
public class MbMainUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 自增主键
    */
    private Integer id;

    /**
     * 主体id
     */
    private Integer bodyId;

    /**
    * 用户名
    */
    private String username;

    /**
    * 姓名
    */
    private String name;

    /**
    * 密码
    */
    private String password;

    /**
    * 手机
    */
    private String phoneNumber;

    /**
    * 是否管理员
    */
    private Short isAdmin;

    /**
    * 锁定状态
    */
    private Short status;

}