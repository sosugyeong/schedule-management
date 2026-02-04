package com.example.schedule.service;

import com.example.schedule.dto.*;
import com.example.schedule.entity.Comment;
import com.example.schedule.entity.Schedule;
import com.example.schedule.exception.CommentLengthException;
import com.example.schedule.exception.ContentLengthException;
import com.example.schedule.exception.NullException;
import com.example.schedule.exception.TitleLengthException;
import com.example.schedule.repository.CommentRepository;
import com.example.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    //저장 (일정 생성)
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request){
        if ("".equals(request.getTitle()) || request.getTitle() == null){
            throw new NullException("제목은 null이거나 공백일 수 없습니다.");
        }
        if ("".equals(request.getContent()) || request.getContent() == null){
            throw new NullException("일정 내용은 null이거나 공백일 수 없습니다.");
        }
        if ("".equals(request.getPassword()) || request.getPassword() == null){
            throw new NullException("비밀번호는 null이거나 공백일 수 없습니다.");
        }
        if ("".equals(request.getUserName()) || request.getUserName() == null){
            throw new NullException("이름은 null이거나 공백일 수 없습니다.");
        }
        if (request.getTitle().length() > 30){
            throw new TitleLengthException("제목은 30자를 넘을 수 없습니다.");
        }
        if (request.getContent().length() > 200){
            throw new ContentLengthException("내용은 200자를 넘을 수 없습니다.");
        }

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
    @Transactional(readOnly = true)
    public List<GetScheduleResponse> findAll(String userName){
        List<Schedule> schedules = scheduleRepository.findByUserNameOrderByModifiedAtDesc(userName);

        List<GetScheduleResponse> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            GetScheduleResponse dto = new GetScheduleResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContent(),
                    schedule.getUserName(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()
            );
            dtos.add(dto);
        }

        //수정일 기준으로 내림차순 정렬
        //dtos.sort(Comparator.comparing(GetScheduleResponse::getModifiedAt).reversed());
        return (dtos != null)? dtos:null;
    }

    //선택 일정 조회
    @Transactional(readOnly = true)
    public GetScheduleCommentResponse.GetSchedule findOne(Long scheduleId){
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("선택한 일정이 없습니다.")
        );

        List<Comment> comment = commentRepository.findByScheduleId(scheduleId);

        //댓글 리스트를 GetComment 리스트로 변환
        List<GetScheduleCommentResponse.GetComment> dtos = new ArrayList<>();
        for(Comment comments : comment){
            GetScheduleCommentResponse.GetComment dto = new GetScheduleCommentResponse.GetComment(
                    comments.getId(),
                    comments.getComment(),
                    comments.getUserName(),
                    comments.getCreatedAt(),
                    comments.getModifiedAt()
            );
            dtos.add(dto);
        }

        return new GetScheduleCommentResponse.GetSchedule(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getUserName(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt(),
                dtos //생성한 댓글 리스트를 넣음
        );
    }

    //선택 일정 수정
    @Transactional
    public UpdateScheduleResponse updateInfo(Long scheduleId, UpdateScheduleRequest request){
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("선택한 일정이 없습니다.")
        );

        if ("".equals(request.getTitle()) || request.getTitle() == null){
            throw new NullException("제목은 null이거나 공백일 수 없습니다.");
        }
        if ("".equals(request.getUserName()) || request.getUserName() == null){
            throw new NullException("이름은 null이거나 공백일 수 없습니다.");
        }
        if(!schedule.getPassword().equals(request.getPassword())){
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }
        if (request.getTitle().length() > 30){
            throw new TitleLengthException("제목은 30자를 넘을 수 없습니다.");
        }

        schedule.updateSchedule(request.getTitle(), request.getUserName());
        return new UpdateScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getUserName(),
                schedule.getModifiedAt()
        );
    }

    //선택 일정 삭제
    @Transactional
    public void delete(Long scheduleId, DeleteScheduleRequest request){
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("선택한 일정이 없습니다.")
        );

        //Schedule에 저장된 비밀번호와 입력된 비밀번호 비교
        if (!schedule.getPassword().equals(request.getPassword())) {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }

        scheduleRepository.deleteById(scheduleId);
    }
}
