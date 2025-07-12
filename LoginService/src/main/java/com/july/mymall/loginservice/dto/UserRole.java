package com.july.mymall.loginservice.dto;

import lombok.Data;

@Data
public class UserRole {
    private Long id;                // ID
    private Long userId;            // 用户ID
    private Long roleId;            // 角色ID
}
