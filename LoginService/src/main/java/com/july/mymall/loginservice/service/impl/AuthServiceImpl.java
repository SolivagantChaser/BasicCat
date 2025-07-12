package com.july.mymall.loginservice.service.impl;

import com.july.mymall.loginservice.dto.DeviceInfo;
import com.july.mymall.loginservice.response.LoginResponse;
import com.july.mymall.loginservice.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public LoginResponse login(String userName, String password, DeviceInfo deviceInfo) {
        return null;
    }

    @Override
    public void logout(String token) {

    }

    @Override
    public String refreshToken(String oldToken) {
        return null;
    }
}
