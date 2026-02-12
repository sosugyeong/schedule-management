package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //일정고유식별자
    private String comment;
    private String userName;
    private String password;

    //일정이 있어야 댓글을 작성할 수 있으니까 null을 허용하지 않는다.
    //댓글을 바로 볼 수 있게 eager로 함.
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "schedule_id", nullable = false) //FK 컬럼의 NULL 비허용
    private Schedule schedule;

    public Comment(String comment, String userName, String password, Schedule schedule) {
        this.comment = comment;
        this.userName = userName;
        this.password = password;
        this.schedule = schedule;
    }

    //댓글 수정
    public void updateComment(String comment, String uesrName){
        this.comment = comment;
        this.userName = uesrName;
    }
}
