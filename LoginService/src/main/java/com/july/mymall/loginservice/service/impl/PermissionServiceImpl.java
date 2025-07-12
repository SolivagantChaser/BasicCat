package com.july.mymall.loginservice.service.impl;

import com.july.mymall.loginservice.dto.Permission;
import com.july.mymall.loginservice.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Override
    public List<Permission> getPermissions(String token) {
        return null;
    }
}
