package com.example.schedule.dto.user;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateUserResponse {
    private final String userName;
    private final String email;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CreateUserResponse(String userName, String email, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.userName = userName;
        this.email = email;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
