package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String userName;
    private String password;

    //일정이 삭제되면 댓글도 같이 삭제되게 함
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> commentList = new ArrayList<>();

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
