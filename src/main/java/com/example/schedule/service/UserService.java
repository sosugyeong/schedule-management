package com.example.schedule.service;

import com.example.schedule.dto.user.*;
import com.example.schedule.entity.User;
import com.example.schedule.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //유저 생성
    @Transactional
    public SignupResponse save(@Valid SignupRequest request){
        User user = new User(
                request.getUserName(),
                request.getEmail(),
                request.getPassword()
        );

        User savedUser = userRepository.save(user);
        return new SignupResponse(
                savedUser.getUserName(),
                savedUser.getEmail(),
                savedUser.getCreatedAt(),
                savedUser.getModifiedAt()
        );
    }

    //유저 전체 조회
    @Transactional(readOnly = true)
    public List<GetUserResponse> findAll(){
        List<User> users = userRepository.findAll();
        List<GetUserResponse> dtos = new ArrayList<>();
        for(User user : users){
            GetUserResponse dto = new GetUserResponse(
                    user.getId(),
                    user.getUserName(),
                    user.getEmail()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    //유저 단건 조회
    @Transactional(readOnly = true)
    public GetUserResponse findById(Long id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("선택한 유저가 없습니다.")
        );

        return new GetUserResponse(
                user.getId(),
                user.getUserName(),
                user.getEmail()
        );
    }

    //유저 수정
    @Transactional
    public UpdateUserResponse update(Long id, @Valid UpdateUserRequest request){
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("선택한 유저가 없습니다.")
        );

        user.updateUser(request.getUserName(), request.getEmail(), request.getPassword());
        return new UpdateUserResponse(
                user.getId(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword()
        );
    }

    //유저 삭제
    @Transactional
    public void delete(Long id){
        boolean findUser = userRepository.existsById(id);
        if (!findUser){
            throw new IllegalStateException("선택한 유저가 없습니다.");
        }

        userRepository.deleteById(id);
    }

    //로그인
    @Transactional(readOnly = true)
    public SessionUser login(@Valid LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다.")
        );

        return new SessionUser(
                user.getId(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword()
        );
    }
}
