package com.example.schedule.service;

import com.example.schedule.dto.CreateCommentRequest;
import com.example.schedule.dto.CreateCommentResponse;
import com.example.schedule.entity.Comment;
import com.example.schedule.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    //댓글 생성
    @Transactional
    public CreateCommentResponse save(Long scheduleId, CreateCommentRequest request){
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
