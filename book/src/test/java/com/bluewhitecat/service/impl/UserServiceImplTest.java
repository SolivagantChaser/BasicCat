package com.bluewhitecat.service.impl;

import com.bluewhitecat.pojo.User;
import com.bluewhitecat.service.UserService;
import org.junit.Test;

public class UserServiceImplTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null, "bbb", "6666", "bbb666@qq.com"));
        userService.registerUser(new User(null, "aaa", "6666", "aaa666@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "aaa", "6666", null)));
        System.out.println(userService.login(new User(null, "aaa", "66666", null)));
    }

    @Test
    public void isExistedUser() {
        if(userService.isExistedUser("aaa")) {
            System.out.println("用户名已存在");
        } else {
            System.out.println("用户名不存在");
        }
    }
}