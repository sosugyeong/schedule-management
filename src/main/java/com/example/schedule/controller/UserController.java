package com.example.schedule.controller;

import com.example.schedule.dto.user.*;
import com.example.schedule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //유저 생성
    @PostMapping("/users")
    public ResponseEntity<CreateUserResponse> create(@RequestBody CreateUserRequest request) {
        CreateUserResponse result = userService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    //전체 유저 조회
    @GetMapping("/users")
    public ResponseEntity<List<GetUserResponse>> getUser(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    //선택 유저 조회
    @GetMapping("/users/{userId}")
    public ResponseEntity<GetUserResponse> getUser(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(userId));
    }

    //선택 유저 수정
    @PatchMapping("/users/{userId}")
    public ResponseEntity<UpdateUserResponse> updateUser(
            @PathVariable Long userId,
            @RequestBody UpdateUserRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(userId, request));
    }

    //선택 유저 삭제
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUSer(@PathVariable Long userId){
        userService.delete(userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
