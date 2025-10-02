package com.july.mymall.commonservice.dao;

import com.july.mymall.commonservice.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends IBaseDao<User, Long> {
}
