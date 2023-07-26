package com.spacebetween.linket.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Attendance {
    @Id
    @GeneratedValue
    @Column(name="att_id")
    private Long id;

    private LocalDateTime attDate;

    private LocalDateTime attStartDatetime;

    private LocalDateTime attEndDatetime;

    @Column(nullable = false)
    private char attStartBnt;

    @Column(nullable = false)
    private char attEndBnt;

//    @ManyToOne
//    @JoinColumn(name="att_email")
//    private User user;

//    @ManyToOne
//    @JoinColumn(name="att_event_id")
//    private Event event;
}