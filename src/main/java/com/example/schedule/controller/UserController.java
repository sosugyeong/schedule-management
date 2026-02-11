package com.example.schedule.controller;

import com.example.schedule.dto.user.*;
import com.example.schedule.entity.User;
import com.example.schedule.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //유저 생성(회원가입)
    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody SignupRequest request) {
        SignupResponse result = userService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity<Void> login(
            @Valid @RequestBody LoginRequest request, HttpSession session
    ){
        SessionUser sessionUser = userService.login(request);
        session.setAttribute("loginUser", sessionUser);

        return ResponseEntity.status(HttpStatus.OK).build();
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
    @PatchMapping("/users")
    public ResponseEntity<UpdateUserResponse> updateUser(
            @SessionAttribute(name = "loginUser", required = false) SessionUser sessionUser,
            @RequestBody UpdateUserRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(sessionUser.getId(), request));
    }

    //선택 유저 삭제
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUSer(@PathVariable Long userId){
        userService.delete(userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
