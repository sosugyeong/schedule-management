package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleRequest {
    private String title;
    private String comment;
    private String userName;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
