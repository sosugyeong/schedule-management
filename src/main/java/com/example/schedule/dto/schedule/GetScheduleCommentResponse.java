package com.example.schedule.dto.schedule;

import com.example.schedule.dto.comment.GetCommentResponse;
import com.example.schedule.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

//일정+댓글 조회
@Getter
public class GetScheduleCommentResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String userName;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    //Comment 엔티티 말고 dto 리스트로 변경함
    private final List<GetCommentResponse> commentList;

    public GetScheduleCommentResponse(
            Long id,
            String title,
            String content,
            String userName,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt,
            List<GetCommentResponse> commentList
    ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.commentList = commentList;
    }

}
