package com.example.schedule.dto.schedule;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

//일정+댓글 조회
public class GetScheduleCommentResponse {
    @Getter
    public static class GetSchedule{
        private final Long id;
        private final String title;
        private final String content;
        private final String userName;
        private final LocalDateTime createdAt;
        private final LocalDateTime modifiedAt;
        private final List<GetComment> getCommentList;

        public GetSchedule(
                Long id,
                String title,
                String content,
                String userName,
                LocalDateTime createdAt,
                LocalDateTime modifiedAt,
                List<GetComment> getCommentList
        ) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.userName = userName;
            this.createdAt = createdAt;
            this.modifiedAt = modifiedAt;
            this.getCommentList = getCommentList;
        }
    }

    @Getter
    public static class GetComment{
        private final Long id;
        private final String comment;
        private final String userName;
        private final LocalDateTime createdAt;
        private final LocalDateTime modifiedAt;

        public GetComment(Long id, String comment, String userName, LocalDateTime createdAt, LocalDateTime modifiedAt) {
            this.id = id;
            this.comment = comment;
            this.userName = userName;
            this.createdAt = createdAt;
            this.modifiedAt = modifiedAt;
        }
    }
}
