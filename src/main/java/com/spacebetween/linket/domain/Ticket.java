package com.spacebetween.linket.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Ticket {

    @Id @GeneratedValue
    @Column(name = "ticket_id")
    private Long id; // 티켓 아이디 자동생성

    @Column(nullable = false)
    private String serialNum; // 일련번호

    @Column(nullable = false, columnDefinition = "varchar(10) default 'N'")
    private String ticketReg; // 티켓 등록여부 (일련번호 사용성여부 파악, default: 'N')

    @Column(nullable = false, columnDefinition = "varchar(10) default 'Y'")
    private String ticketStatus; // 티켓 사용가능여부 (default: 'Y')

    @CreatedDate
    @Column(updatable = false)
    @DateTimeFormat
    private String regDate; // 티켓등록일자

    @LastModifiedDate
    private String lastUpdatedDate; // 수정일자

    @Column(nullable = false)
    private String seat; // 좌석

    @OneToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

//    public void setTicket(Users user, Ticket ticket)
}
