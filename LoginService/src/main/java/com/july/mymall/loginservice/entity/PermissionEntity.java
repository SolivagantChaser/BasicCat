package com.july.mymall.loginservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_permission")
public class PermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // ID
    @Column(name = "code", nullable = false, unique = true)
    private String code;            // 权限码（如：user:list）
    @Column(name = "name", nullable = false, unique = true)
    private String name;            // 权限名称
    @Column(name = "description", nullable = false, unique = true)
    private String description;     // 描述
    @Column(name = "url", nullable = false, unique = true)
    private String url;             // 关联URL
    @Column(name = "type", nullable = false, unique = true)
    private Integer type;           // 类型（1-菜单，2-按钮，3-API）
}
