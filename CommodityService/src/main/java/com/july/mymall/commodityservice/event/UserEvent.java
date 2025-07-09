package com.july.mymall.commodityservice.event;

import lombok.Data;

import java.util.List;

@Data
public class UserEvent {
    private Long userId;

    private List<String> roles;

    private List<String> permissions;
}
