package com.july.mymall.loginservice.dto;

import lombok.Data;

@Data
public class RolePermission {
    private Long id;                // ID
    private Long roleId;            // 角色ID
    private Long permissionId;      // 权限ID
}
