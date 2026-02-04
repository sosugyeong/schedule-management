package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateCommentRequest {
    //scheduleId는 url 경로로 받음
    //private Long scheduleId;
    private String comment;
    private String userName;
    private String password;
}
