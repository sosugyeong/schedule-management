package com.example.schedule.dto.user;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SignupResponse {
    private final String userName;
    private final String email;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public SignupResponse(String userName, String email, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.userName = userName;
        this.email = email;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
