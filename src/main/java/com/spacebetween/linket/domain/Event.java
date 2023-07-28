package com.spacebetween.linket.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Event {

    @Id @GeneratedValue
    @Column(name = "event_id")
    private Long id; // 행사 아이디 자동생성

    private String eventName; // 행사명
    private String eventType; // 행사 종류
    private String place; // 행사 장소
    private String placeId; // 행사 고유 아이디
    private String eventImage; // 행사 이미지
    private String eventInq; // 행사 대표문의처
    private String eventDesc; // 행사 설명
    private String eventStatus; // 진행 여부 (default: 'Y')
    private String startDate; // 행사 시작일자
    private String endDate; // 행사 종료일자
    @CreatedDate
    private LocalDateTime regDate; // 등록일자
    @LastModifiedDate
    private LocalDateTime lastUpdatedDate; // 수정일자
    @LastModifiedDate
    private LocalDateTime deletedDate; // 삭제일자
    private String link; // 링크

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "event")
    private List<Hire> hires = new ArrayList<>();

    @OneToMany(mappedBy = "event")
    private List<Ticket> tickets = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public String getEventInq() {
        return eventInq;
    }

    public void setEventInq(String eventInq) {
        this.eventInq = eventInq;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public LocalDateTime getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(LocalDateTime deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Hire> getHires() {
        return hires;
    }

    public void setHires(List<Hire> hires) {
        this.hires = hires;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
