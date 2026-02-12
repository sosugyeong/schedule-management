package com.example.schedule.controller;

import com.example.schedule.dto.schedule.*;
import com.example.schedule.dto.user.SessionUser;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import com.example.schedule.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;

    //일정 생성
    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponse> create(
            @SessionAttribute(name = "loginUser") SessionUser sessionUser,
            @Valid @RequestBody CreateScheduleRequest request
    ){
        CreateScheduleResponse result = scheduleService.save(sessionUser.getId(), request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    //전체 일정 조회
    //, @RequestParam(value = "page", defaultValue = "0") int page
    @GetMapping("/schedules")
    public ResponseEntity<List<GetScheduleResponse>> getSchedule(@RequestParam(name="userName", required = false) String userName){
        //Page<GetScheduleResponse> paging = this.scheduleService.findAll(userName);
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findAll(userName));

    }

    //선택 일정 조회
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<GetScheduleCommentResponse> getSchedule(@PathVariable Long scheduleId){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findOne(scheduleId));
    }

    //선택 일정 수정
    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<UpdateScheduleResponse> updateSchedule(
            @SessionAttribute(name = "loginUser") SessionUser sessionUser,
            @PathVariable Long scheduleId,
            @Valid @RequestBody UpdateScheduleRequest request
    ){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.updateInfo(sessionUser.getId(), scheduleId, request));
    }

    //선택 일정 삭제
    @DeleteMapping("/schedules/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(
            @SessionAttribute(name = "loginUser") SessionUser sessionUser,
            @PathVariable Long scheduleId,
            @Valid @RequestBody DeleteScheduleRequest request
    ){
        scheduleService.delete(sessionUser.getId(), scheduleId, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
