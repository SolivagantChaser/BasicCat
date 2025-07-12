package com.july.mymall.loginservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_device_info")
public class DeviceInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键
}
