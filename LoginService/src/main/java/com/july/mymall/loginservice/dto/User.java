package com.july.mymall.loginservice.dto;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;                // 用户ID
    private String username;        // 用户名
    private String password;        // 加密密码
    private String mobile;          // 手机号
    private String email;           // 邮箱
    private Integer status;         // 用户状态（1-正常，2-锁定，3-禁用）
    private Date createTime;        // 创建时间
    private Date lastLoginTime;     // 最后登录时间
    private String lastLoginIp;     // 最后登录IP
    // 扩展字段
    private String avatar;          // 头像
    private String nickname;        // 昵称
}