package com.july.mymall.commonservice.dao;

import com.july.mymall.commonservice.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface IBaseDao<T extends BaseEntity, I extends Serializable> extends JpaRepository<T, I>, JpaSpecificationExecutor<T> {
}
