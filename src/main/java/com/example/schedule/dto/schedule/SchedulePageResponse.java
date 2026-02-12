package com.example.schedule.dto.schedule;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SchedulePageResponse {
    private String title;
    private String content;
    private String userName;
    private int commentsCount;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
