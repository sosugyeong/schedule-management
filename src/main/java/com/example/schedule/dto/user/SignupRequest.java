package com.example.schedule.dto.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class SignupRequest {
    @NotBlank(message = "이름은 필수 입력값입니다.")
    @Size(max = 5, message = "유저명은 5글자 이내이어야 합니다.")
    private String userName;

    @NotBlank(message = "이메일은 필수 입력값입니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    @Length(min = 8, message = "비밀번호는 8글자 이상이어야 합니다.")
    private String password;
}
