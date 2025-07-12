package com.july.mymall.loginservice.service;

import com.july.mymall.loginservice.dto.DeviceInfo;
import com.july.mymall.loginservice.response.LoginResponse;

public interface AuthService {
    LoginResponse login(String userName, String password, DeviceInfo deviceInfo);

    void logout(String token);

    String refreshToken(String oldToken);
}
