package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String title;

    @Column(length = 200, nullable = false)
    private String content;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;


    public Schedule(String title, String content, String userName, String password){
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.password = password;
    }

    //일정 수정(일정제목, 작성자명)
    public void updateSchedule(String title, String userName){
        this.title = title;
        this.userName = userName;
    }
}
