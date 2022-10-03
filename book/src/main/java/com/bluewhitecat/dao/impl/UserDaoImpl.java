package com.bluewhitecat.dao.impl;

import com.bluewhitecat.dao.BaseDao;
import com.bluewhitecat.dao.UserDao;
import com.bluewhitecat.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String userName) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username=?";
        return queryForOne(User.class, sql, userName);
    }

    @Override
    public User queryUserByUsernameAndPassword(String userName, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username=? and password=?";
        return queryForOne(User.class, sql, userName, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`) values(?, ?, ?)";
        return update(sql, user.getUserName(), user.getPassword(), user.getEmail());
    }
}
