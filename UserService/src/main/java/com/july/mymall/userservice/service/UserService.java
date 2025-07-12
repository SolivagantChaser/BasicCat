package com.july.mymall.userservice.service;

import com.july.mymall.userservice.request.RegisterRequest;

public interface UserService {
    long register(RegisterRequest request);
}
