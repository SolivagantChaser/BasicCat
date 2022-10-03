package com.bluewhitecat.service;

import com.bluewhitecat.pojo.User;

public interface UserService {

    /**
     * 注册用户
     * @param user 用户
     */
    public void registerUser(User user);

    /**
     * 登录
     * @param user 用户
     * @return
     */
    public User login(User user);

    /**
     * 检查用户是否已存在
     * @param userName
     * @return
     */
    public boolean isExistedUser(String userName);
}
