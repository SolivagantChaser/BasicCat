package com.july.mymall.loginservice.controller;

import com.july.mymall.loginservice.dto.Permission;
import com.july.mymall.loginservice.request.LoginRequest;
import com.july.mymall.loginservice.response.LoginResponse;
import com.july.mymall.loginservice.response.Result;
import com.july.mymall.loginservice.service.AuthService;
import com.july.mymall.loginservice.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    private final PermissionService permissionService;

    public AuthController(AuthService authService, PermissionService permissionService) {
        this.authService = authService;
        this.permissionService = permissionService;
    }

    @PostMapping("/login")
    public Result<LoginResponse> login(@RequestBody LoginRequest request) {
        return Result.success(authService.login(
                request.getUsername(),
                request.getPassword(),
                request.getDeviceInfo()
        ));
    }

    @PostMapping("/logout")
    public Result<Void> logout(@RequestHeader("Authorization") String token) {
        authService.logout(token);
        return Result.success("logout success");
    }

    // 刷新Token
    @PostMapping("/refresh-token")
    public Result<String> refreshToken(@RequestHeader("Authorization") String token) {
        return Result.success(authService.refreshToken(token));
    }

    // 获取用户权限
    @GetMapping("/permissions")
    public Result<List<Permission>> getPermissions(@RequestHeader("Authorization") String token) {
        return Result.success(permissionService.getPermissions(token));
    }
}
