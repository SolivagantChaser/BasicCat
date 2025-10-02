package com.july.mymall.commonservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_role")
public class Role implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    private String name;

    private String roleKey;

    private String description;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
