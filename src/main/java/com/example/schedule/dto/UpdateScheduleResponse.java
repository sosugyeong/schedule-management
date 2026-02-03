package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String userName;
    private final LocalDateTime modifiedAt;

    public UpdateScheduleResponse(Long id, String title, String content, String userName, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.modifiedAt = modifiedAt;
    }
}
