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
    private Long scheduleId;

    @Column(length = 200, nullable = false)
    private String comment;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;

    public Comment(Long scheduleId, String comment, String userName, String password) {
        this.scheduleId = scheduleId;
        this.comment = comment;
        this.userName = userName;
        this.password = password;
    }

    //댓글 수정
    public void updateComment(String comment, String uesrName){
        this.comment = comment;
        this.userName = uesrName;
    }
}
