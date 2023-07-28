package com.spacebetween.linket.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hire {

    @Id @GeneratedValue
    @Column(name = "hire_id")
    private Long id;

    private String workName; // 공고명
    private Integer workHour; // 근무시간
    private String workStartDay; // 근무시작일
    private String workEndDay; // 근무종료일
    private Integer pay; // 시급
    private String edu; // 사전교육
    private LocalDateTime regDate; // 등록일자

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @OneToMany(mappedBy = "hire")
    private List<Attendance> attendances = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public Integer getWorkHour() {
        return workHour;
    }

    public void setWorkHour(Integer workHour) {
        this.workHour = workHour;
    }

    public String getWorkStartDay() {
        return workStartDay;
    }

    public void setWorkStartDay(String workStartDay) {
        this.workStartDay = workStartDay;
    }

    public String getWorkEndDay() {
        return workEndDay;
    }

    public void setWorkEndDay(String workEndDay) {
        this.workEndDay = workEndDay;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }
}
