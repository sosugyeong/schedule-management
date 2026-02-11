package com.example.schedule.dto.user;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class LoginRequest {
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;
    @Length(min = 8)
    private String password;
}
