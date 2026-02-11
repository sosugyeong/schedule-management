package com.example.schedule.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandeler {

    /*
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handle(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }*/

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handler(MethodArgumentNotValidException e){
        Map<String, String> errors = new HashMap<>();
        e.getAllErrors().forEach(
                c -> errors.put(((FieldError)c).getField(), c.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(errors);
    }
}
