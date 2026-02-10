package com.example.schedule.dto.schedule;

import lombok.Getter;

@Getter
public class CreateScheduleRequest {
    private String title;
    private String content;
    private String userName;
    private String password;
//    private LocalDateTime createdAt;
//    private LocalDateTime modifiedAt;
}
