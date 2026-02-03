package com.example.schedule.service;

import com.example.schedule.dto.CreateScheduleRequest;
import com.example.schedule.dto.CreateScheduleResponse;
import com.example.schedule.dto.GetScheduleResponse;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    //저장 (일정 생성)
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request){
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getUserName(),
                request.getPassword()
        );

        Schedule saveSchedule = scheduleRepository.save(schedule);
        return new CreateScheduleResponse(
                saveSchedule.getTitle(),
                saveSchedule.getContent(),
                saveSchedule.getUserName(),
                saveSchedule.getCreatedAt(),
                saveSchedule.getModifiedAt()
        );
    }

    //전체 일정 조회
    //public List<GetScheduleResponse> getAll() {
        //List<>
    //}
    //선택 일정 조회
    //선택 일정 수정
    //선택 일정 삭제

}
