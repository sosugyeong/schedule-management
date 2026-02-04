package com.example.schedule.service;

import com.example.schedule.dto.CreateCommentRequest;
import com.example.schedule.dto.CreateCommentResponse;
import com.example.schedule.entity.Comment;
import com.example.schedule.exception.CommentLengthException;
import com.example.schedule.exception.NullException;
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
        if ("".equals(request.getComment()) || request.getComment() == null){
            throw new NullException("내용은 null이거나 공백일 수 없습니다.");
        }
        if ("".equals(request.getPassword()) || request.getPassword() == null){
            throw new NullException("비밀번호는 null이거나 공백일 수 없습니다.");
        }
        if ("".equals(request.getUserName()) || request.getUserName() == null){
            throw new NullException("이름은 null이거나 공백일 수 없습니다.");
        }
        if (request.getComment().length() > 100){
            throw new CommentLengthException("댓글 내용은 100자를 넘을 수 없습니다.");
        }

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
