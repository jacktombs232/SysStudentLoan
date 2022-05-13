package com.example.sysstudentloan.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * account
 * @author 
 */
@Data
public class Account implements Serializable {
    /**
     * 账号
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 电子邮箱
     */
    private String email;

    private Integer enable;

    private String phone;

    /**
     * 角色
     */
    private String role;

    private static final long serialVersionUID = 1L;
}