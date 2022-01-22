package com.first.group.mainbody.vos;

import lombok.Data;

import java.io.Serializable;

@Data
public class MainUserVo implements Serializable {

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
     * 手机
     */
    private String phoneNumber;

    /**
     * 是否管理员
     */
    private Short isAdmin;
}
