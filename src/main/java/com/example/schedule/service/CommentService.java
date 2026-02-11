package com.example.schedule.service;

import com.example.schedule.dto.comment.CreateCommentRequest;
import com.example.schedule.dto.comment.CreateCommentResponse;
import com.example.schedule.entity.Comment;
import com.example.schedule.repository.CommentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    //댓글 생성
    @Transactional
    public CreateCommentResponse save(Long scheduleId, @Valid CreateCommentRequest request){
        long num = commentRepository.countByScheduleId(scheduleId);
        if (num >= 10){
            throw new IllegalStateException("댓글 갯수는 10개를 넘을 수 없습니다.");
        }

        Comment comment = new Comment(
                scheduleId,
                request.getComment(),
                request.getUserName(),
                request.getPassword()
        );
        Comment saveComment = commentRepository.save(comment);
        return new CreateCommentResponse(
                saveComment.getComment(),
                saveComment.getUserName(),
                saveComment.getCreatedAt(),
                saveComment.getModifiedAt()
        );
    }

}
