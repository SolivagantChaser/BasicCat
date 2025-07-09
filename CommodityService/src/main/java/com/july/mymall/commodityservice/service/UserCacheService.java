package com.july.mymall.commodityservice.service;

import com.july.mymall.commodityservice.dto.User;
import com.july.mymall.commodityservice.event.UserEvent;

public interface UserCacheService {
    User getUser(Long userId);

    void handleUserEvent(UserEvent userEvent);
}
