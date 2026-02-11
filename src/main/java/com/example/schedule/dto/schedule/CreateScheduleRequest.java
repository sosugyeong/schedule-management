package com.example.schedule.dto.schedule;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateScheduleRequest {
    @NotBlank(message = "제목은 필수 입력값입니다.")
    @Size(max = 30, message = "제목은 30자 이내이어야 합니다.")
    private String title;

    @NotBlank(message = "내용은 필수 입력값입니다.")
    @Size(max = 200, message = "내용은 200자 이내이어야 합니다.")
    private String content;

    @NotBlank(message = "이름은 필수 입력값입니다.")
    @Size(max = 5, message = "유저명은 5글자 이내이어야 합니다.")
    private String userName;

    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    @Size(min = 8, message = "비밀번호는 8글자 이상이어야 합니다.")
    private String password;
}
