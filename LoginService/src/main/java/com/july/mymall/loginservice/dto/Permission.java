package com.july.mymall.loginservice.dto;

import lombok.Data;

@Data
public class Permission {
    private Long id;                // ID
    private String code;            // 权限码（如：user:list）
    private String name;            // 权限名称
    private String description;     // 描述
    private String url;             // 关联URL
    private Integer type;           // 类型（1-菜单，2-按钮，3-API）
}
