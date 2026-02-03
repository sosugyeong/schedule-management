package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponse {
    private final String title;
    private final String comment;
    private final String userName;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CreateScheduleResponse(String title, String comment, String userName, LocalDateTime createdAt, LocalDateTime modifiedAt){
        this.title = title;
        this.comment = comment;
        this.userName = userName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
