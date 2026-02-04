package com.example.schedule.controller;

import com.example.schedule.dto.CreateCommentRequest;
import com.example.schedule.dto.CreateCommentResponse;
import com.example.schedule.dto.CreateScheduleRequest;
import com.example.schedule.dto.CreateScheduleResponse;
import com.example.schedule.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //댓글 생성
    @PostMapping("/schedule/{scheduleId}/comments")
    public ResponseEntity<CreateCommentResponse> create(@PathVariable Long scheduleId, @RequestBody CreateCommentRequest request){
        CreateCommentResponse result = commentService.save(scheduleId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    //선택 댓글 조회

    //선택 댓글 수정

    //선택 댓글 삭제
}
