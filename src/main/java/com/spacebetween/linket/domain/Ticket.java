package com.spacebetween.linket.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ticket {

    @Id @GeneratedValue
    @Column(name = "ticket_id")
    private Long id; // 티켓 아이디 자동생성
    private Long ticketEventId;
    private Long ticketCompanyId;
    private String ticketEmail;
    private String serialNum; // 일련번호
    private String ticketReg; // 티켓 등록여부 (일련번호 사용성여부 파악, default: 'N')
    private String ticketStatus; // 티켓 사용가능여부 (default: 'Y')
    private String regDate; // 티켓등록일자
    private String lastUpdatedDate; // 수정일자
    private String seat; // 좌석
}
