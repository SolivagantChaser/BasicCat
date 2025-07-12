package com.july.mymall.loginservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_user_role")
public class UserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // ID
    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;            // 用户ID
    @Column(name = "role_id", nullable = false)
    private Long roleId;            // 角色ID
}
