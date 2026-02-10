package com.example.schedule.dto.user;

import lombok.Getter;

@Getter
public class UpdateUserRequest {
    private String userName;
    private String email;
    private String password;
}
