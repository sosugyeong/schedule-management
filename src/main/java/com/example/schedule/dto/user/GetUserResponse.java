package com.example.schedule.dto.user;

import lombok.Getter;

@Getter
public class GetUserResponse {
    private final Long id;
    private final String userName;
    private final String email;
    private final String password;

    public GetUserResponse(Long id, String userName, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
