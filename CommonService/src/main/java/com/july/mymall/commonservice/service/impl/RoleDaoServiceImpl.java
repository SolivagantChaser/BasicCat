package com.july.mymall.commonservice.service.impl;

import com.july.mymall.commonservice.dao.IBaseDao;
import com.july.mymall.commonservice.dao.RoleDao;
import com.july.mymall.commonservice.entity.Role;
import com.july.mymall.commonservice.service.BaseDaoServiceImpl;
import com.july.mymall.commonservice.service.IRoleDaoService;
import org.springframework.stereotype.Service;

@Service
public class RoleDaoServiceImpl extends BaseDaoServiceImpl<Role, Long> implements IRoleDaoService {

    public final RoleDao roleDao;

    public RoleDaoServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public IBaseDao<Role, Long> getBaseDao() {
        return roleDao;
    }
}
