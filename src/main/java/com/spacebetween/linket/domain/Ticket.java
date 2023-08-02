package com.spacebetween.linket.domain;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id @GeneratedValue
    @Column(name = "ticket_id")
    private Long id; // 티켓 아이디 자동생성

    private String serialNum; // 일련번호
    private String ticketReg; // 티켓 등록여부 (일련번호 사용성여부 파악, default: 'N')
    private String ticketStatus; // 티켓 사용가능여부 (default: 'Y')
    private String regDate; // 티켓등록일자
    private String lastUpdatedDate; // 수정일자
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getTicketReg() {
        return ticketReg;
    }

    public void setTicketReg(String ticketReg) {
        this.ticketReg = ticketReg;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
