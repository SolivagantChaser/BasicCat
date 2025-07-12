package com.july.mymall.loginservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_role_permission")
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // ID
    @Column(name = "role_id", nullable = false, unique = true)
    private Long roleId;            // 角色ID
    @Column(name = "permission_id", nullable = false, unique = true)
    private Long permissionId;      // 权限ID
}
