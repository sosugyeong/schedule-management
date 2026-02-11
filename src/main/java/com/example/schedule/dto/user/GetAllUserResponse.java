package com.example.schedule.dto.user;

import lombok.Getter;

@Getter
public class GetAllUserResponse {
    private final Long id;
    private final String userName;
    private final String email;

    public GetAllUserResponse(Long id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }
}
