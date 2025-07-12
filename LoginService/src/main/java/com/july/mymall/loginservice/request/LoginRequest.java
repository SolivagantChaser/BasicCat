package com.july.mymall.loginservice.request;

import com.july.mymall.loginservice.dto.DeviceInfo;
import lombok.Data;

@Data
public class LoginRequest {
    private String username;

    private String password;

    private DeviceInfo deviceInfo;
}
