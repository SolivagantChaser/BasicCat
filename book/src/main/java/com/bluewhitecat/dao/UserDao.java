package com.bluewhitecat.dao;

import com.bluewhitecat.pojo.User;

public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param userName 用户名
     * @return 如果返回null，说明没有这个用户
     */
    public User queryUserByUsername(String userName);

    /**
     * 根据用户名和密码查询用户信息
     * @param userName  用户名
     * @param password  用户密码
     * @return 如果返回null，说明没有这个用户
     */
    public User queryUserByUsernameAndPassword(String userName, String password);

    /**
     * 注册用户信息
     * @param user 用户信息
     * @return
     */
    public int saveUser(User user);
}
