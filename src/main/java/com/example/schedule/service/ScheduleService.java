package com.example.schedule.service;

import com.example.schedule.dto.CreateScheduleRequest;
import com.example.schedule.dto.CreateScheduleResponse;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    //저장 (일정 생성)
    public CreateScheduleResponse save(CreateScheduleRequest request){
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getComment(),
                request.getUserName(),
                request.getPassword()
        );

        Schedule saveSchedule = scheduleRepository.save(schedule);
        return new CreateScheduleResponse(
                saveSchedule.getTitle(),
                saveSchedule.getComment(),
                saveSchedule.getUserName(),
                saveSchedule.getCreatedAt(),
                saveSchedule.getModifiedAt()
        );
    }

    //전체 일정 조회
    //선택 일정 조회
    //선택 일정 수정
    //선택 일정 삭제

}
