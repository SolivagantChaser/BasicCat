package com.july.mymall.commonservice.service.impl;

import com.july.mymall.commonservice.dao.IBaseDao;
import com.july.mymall.commonservice.dao.UserDao;
import com.july.mymall.commonservice.entity.User;
import com.july.mymall.commonservice.service.BaseDaoServiceImpl;
import com.july.mymall.commonservice.service.IUserDaoBaseService;
import org.springframework.stereotype.Service;

@Service
public class UserDaoServiceImpl extends BaseDaoServiceImpl<User, Long> implements IUserDaoBaseService {
    private final UserDao userDao;

    public UserDaoServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public IBaseDao<User, Long> getBaseDao() {
        return userDao;
    }
}
