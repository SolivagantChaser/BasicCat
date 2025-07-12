package com.july.mymall.loginservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "tb_user_session")
public class UserSessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "token", nullable = false, unique = true)
    private String token;           // Token
    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;            // 用户ID
    @Column(name = "device_info", nullable = false, unique = true)
    private String deviceInfo;      // 设备信息
    @Column(name = "ip", nullable = false, unique = true)
    private String ip;              // IP地址
    @Column(name = "create_time", nullable = false)
    private Date createTime;        // 创建时间
    @Column(name = "expire_time", nullable = false)
    private Date expireTime;        // 过期时间
    @Column(name = "active", nullable = false)
    private Boolean isActive;       // 是否活跃
}
