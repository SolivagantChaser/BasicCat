package com.july.mymall.loginservice.service;

import com.july.mymall.loginservice.dto.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> getPermissions(String token);
}
