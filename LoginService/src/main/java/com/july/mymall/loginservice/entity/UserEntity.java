package com.july.mymall.loginservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "tb_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // 用户ID
    @Column(name = "username", nullable = false, unique = true)
    private String username;        // 用户名
    @Column(name = "password", nullable = false)
    private String password;        // 加密密码
    @Column(name = "mobile", nullable = false, unique = true)
    private String mobile;          // 手机号
    @Column(name = "email", nullable = false, unique = true)
    private String email;           // 邮箱
    @Column(name = "status", nullable = false)
    private Integer status;         // 用户状态（1-正常，2-锁定，3-禁用）
    @Column(name = "create_time")
    private Date createTime;        // 创建时间
    @Column(name = "last_login_time")
    private Date lastLoginTime;     // 最后登录时间
    @Column(name = "last_login_ip")
    private String lastLoginIp;     // 最后登录IP
    @Column(name = "nick_name", unique = true)
    private String nickname;        // 昵称
}
