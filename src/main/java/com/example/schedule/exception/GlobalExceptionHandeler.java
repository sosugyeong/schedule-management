package com.example.schedule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandeler {

    //일정 제목
    @ExceptionHandler(TitleLengthException.class)
    public ResponseEntity<String> handleTitleException(TitleLengthException e){
        //400 error
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    //일정 내용
    @ExceptionHandler(ContentLengthException.class)
    public ResponseEntity<String> handleContentLengthException(ContentLengthException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    //댓글 내용
    @ExceptionHandler(CommentLengthException.class)
    public ResponseEntity<String> handleCommentLengthException(CommentLengthException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    //필수값 처리(일정 제목, 일정 내용, 댓글 내용, 비밀번호, 작성자명)
    @ExceptionHandler(NullException.class)
    public ResponseEntity<String> handleNullException(NullException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
