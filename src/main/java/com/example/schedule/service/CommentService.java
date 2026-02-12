package com.example.schedule.service;

import com.example.schedule.dto.comment.CreateCommentRequest;
import com.example.schedule.dto.comment.CreateCommentResponse;
import com.example.schedule.entity.Comment;
import com.example.schedule.entity.Schedule;
import com.example.schedule.entity.User;
import com.example.schedule.repository.CommentRepository;
import com.example.schedule.repository.ScheduleRepository;
import com.example.schedule.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    //댓글 생성
    @Transactional
    public CreateCommentResponse save(Long userId, Long scheduleId, @Valid CreateCommentRequest request){
        long num = commentRepository.countByScheduleId(scheduleId);
        if (num >= 10){
            throw new IllegalStateException("댓글 갯수는 10개를 넘을 수 없습니다.");
        }

        //일정 존재하는지 확인
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("해당 일정이 없습니다.")
        );

        //위에 생성한 schedule을 생성자에 넣어줌
        Comment comment = new Comment(
                request.getComment(),
                request.getUserName(),
                request.getPassword(),
                schedule
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
