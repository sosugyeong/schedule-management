package com.example.schedule.dto.schedule;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleRequest {
    private String title;
    private String content;
    private String userName;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
