package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetScheduleRequest {
    private String title;
    private String content;
    private String userName;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
