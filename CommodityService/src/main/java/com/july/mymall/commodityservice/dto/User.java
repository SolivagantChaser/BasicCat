package com.july.mymall.commodityservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class User {
    private Long userId;

    private List<String> roles;

    private List<String> permissions;
}
