package com.july.mymall.loginservice.repository;

import com.july.mymall.loginservice.entity.UserSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserSessionRepository extends JpaRepository<UserSessionEntity, Long> {
    // 根据 Token 查询会话
    Optional<UserSessionEntity> findByToken(String token);

    // 根据用户 ID 查询活跃会话
    @Query("SELECT s FROM UserSessionEntity s WHERE s.userId = :userId AND s.isActive = true")
    List<UserSessionEntity> findActiveSessionsByUserId(Long userId);

    // 标记会话为不活跃
    @Modifying
    @Transactional
    @Query("UPDATE UserSessionEntity s SET s.isActive = false WHERE s.token = :token")
    int invalidateSession(String token);

    // 删除过期会话
    @Modifying
    @Transactional
    @Query("DELETE FROM UserSessionEntity s WHERE s.expireTime < :currentTime")
    int deleteExpiredSessions(Date currentTime);
}
