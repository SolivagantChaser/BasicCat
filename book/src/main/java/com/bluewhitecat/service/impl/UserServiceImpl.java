package com.bluewhitecat.service.impl;

import com.bluewhitecat.dao.UserDao;
import com.bluewhitecat.dao.impl.UserDaoImpl;
import com.bluewhitecat.pojo.User;
import com.bluewhitecat.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册用户
     * @param user 用户
     */
    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    /**
     * 登录
     * @param user 用户
     * @return
     */
    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUserName(), user.getPassword());
    }

    /**
     * 用户存在查询
     * @param userName
     * @return
     */
    @Override
    public boolean isExistedUser(String userName) {
        return userDao.queryUserByUsername(userName) == null ? false : true;
    }
}
