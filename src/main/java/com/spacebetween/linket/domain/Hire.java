package com.spacebetween.linket.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Hire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hire_id")
    private Long id;
//    @ManyToOne
//    @JoinColumn(name = "hire_event_id")//hireEventId
//    private Event eventId;
//    @ManyToOne
//    @JoinColumn(name = "hire_company_id")//hireCompanyId
//    private Attendance attCompanyId;
    private String workName; // 공고명
    private Integer workHour; // 근무시간
    private String workStartDay; // 근무시작일
    private String workEndDay; // 근무종료일
    private Integer pay; // 시급
    private String edu; // 사전교육
    @CreatedDate
    private LocalDateTime regDate; // 등록일자
}
