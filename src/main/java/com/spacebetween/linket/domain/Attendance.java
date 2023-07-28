package com.spacebetween.linket.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Attendance {

    @Id @GeneratedValue
    @Column(name="att_id")
    private Long id; // 출결 아이디

    private LocalDateTime attDate; // 참여일

    private LocalDateTime attStartDatetime; // 출석일시

    private LocalDateTime attEndDatetime; // 퇴근일시

    @Column(nullable = false)
    private char attStartBnt; // 출석활성화

    @Column(nullable = false) // 퇴근활성화
    private char attEndBnt;

    private LocalDateTime regDate; // 등록일자

    @ManyToOne
    @JoinColumn(name="user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "hire_id")
    private Hire hire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getAttDate() {
        return attDate;
    }

    public void setAttDate(LocalDateTime attDate) {
        this.attDate = attDate;
    }

    public LocalDateTime getAttStartDatetime() {
        return attStartDatetime;
    }

    public void setAttStartDatetime(LocalDateTime attStartDatetime) {
        this.attStartDatetime = attStartDatetime;
    }

    public LocalDateTime getAttEndDatetime() {
        return attEndDatetime;
    }

    public void setAttEndDatetime(LocalDateTime attEndDatetime) {
        this.attEndDatetime = attEndDatetime;
    }

    public char getAttStartBnt() {
        return attStartBnt;
    }

    public void setAttStartBnt(char attStartBnt) {
        this.attStartBnt = attStartBnt;
    }

    public char getAttEndBnt() {
        return attEndBnt;
    }

    public void setAttEndBnt(char attEndBnt) {
        this.attEndBnt = attEndBnt;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }

    public Hire getHire() {
        return hire;
    }

    public void setHire(Hire hire) {
        this.hire = hire;
    }
}