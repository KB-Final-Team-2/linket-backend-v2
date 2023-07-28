package com.spacebetween.linket.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {

    @Id @GeneratedValue
    @Column(name = "review_id")
    private Long id; // 리뷰 아이디

    private Integer rateFacilChair; // 시설 (좌석)
    private Integer rateFacilRest; // 시설 (화장실)
    private Integer rateStaffIn; // 직원 (입장 안내)
    private Integer rateStaffTicket; // 직원 (티켓 발급)
    private Integer rateEventContent; // 행사 구성 만족도
    private Integer rateEventGo; // 행사 진행 만족도
    private String reviewEtc; // 기타 리뷰
    private String regDate; // 등록일자

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRateFacilChair() {
        return rateFacilChair;
    }

    public void setRateFacilChair(Integer rateFacilChair) {
        this.rateFacilChair = rateFacilChair;
    }

    public Integer getRateFacilRest() {
        return rateFacilRest;
    }

    public void setRateFacilRest(Integer rateFacilRest) {
        this.rateFacilRest = rateFacilRest;
    }

    public Integer getRateStaffIn() {
        return rateStaffIn;
    }

    public void setRateStaffIn(Integer rateStaffIn) {
        this.rateStaffIn = rateStaffIn;
    }

    public Integer getRateStaffTicket() {
        return rateStaffTicket;
    }

    public void setRateStaffTicket(Integer rateStaffTicket) {
        this.rateStaffTicket = rateStaffTicket;
    }

    public Integer getRateEventContent() {
        return rateEventContent;
    }

    public void setRateEventContent(Integer rateEventContent) {
        this.rateEventContent = rateEventContent;
    }

    public Integer getRateEventGo() {
        return rateEventGo;
    }

    public void setRateEventGo(Integer rateEventGo) {
        this.rateEventGo = rateEventGo;
    }

    public String getReviewEtc() {
        return reviewEtc;
    }

    public void setReviewEtc(String reviewEtc) {
        this.reviewEtc = reviewEtc;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
