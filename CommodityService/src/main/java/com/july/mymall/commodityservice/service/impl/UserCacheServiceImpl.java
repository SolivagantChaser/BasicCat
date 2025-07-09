package com.july.mymall.commodityservice.service.impl;

import com.alibaba.fastjson2.JSON;
import com.july.mymall.commodityservice.dto.User;
import com.july.mymall.commodityservice.event.UserEvent;
import com.july.mymall.commodityservice.service.UserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserCacheServiceImpl implements UserCacheService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public User getUser(Long userId) {
        return null;
    }

    @Override
    @KafkaListener(topics = "user-auth-topic", groupId = "user-auth-group")
    public void handleUserEvent(UserEvent event) {
        User user = User.builder().userId(event.getUserId()).roles(event.getRoles())
                .permissions(event.getPermissions()).build();

        redisTemplate.opsForValue().set(
                "user:" + event.getUserId(),
                JSON.toJSONString(user),
                30, TimeUnit.MINUTES
        );
    }
}
