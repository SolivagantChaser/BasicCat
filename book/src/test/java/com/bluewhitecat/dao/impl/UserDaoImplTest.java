package com.bluewhitecat.dao.impl;

import com.bluewhitecat.dao.UserDao;
import com.bluewhitecat.pojo.User;
import org.junit.Test;

public class UserDaoImplTest {

    @Test
    public void queryUserByUsername() {
        UserDao userDao = new UserDaoImpl();
        if (userDao.queryUserByUsername("admin") == null) {
            System.out.println("用户名不存在");
        } else {
            System.out.println("用户已存在");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        UserDao userDao = new UserDaoImpl();
        if (userDao.queryUserByUsernameAndPassword("admin", "admin") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("登陆成功");
        }
    }

    @Test
    public void saveUser() {
        UserDao userDao = new UserDaoImpl();
        userDao.saveUser(new User(null, "common", "1233456", "www@qq.com"));
    }
}