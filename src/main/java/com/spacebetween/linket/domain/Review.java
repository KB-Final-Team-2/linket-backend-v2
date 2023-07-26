package com.spacebetween.linket.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {

    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private Long id; // 리뷰 아이디

    @Column(name = "rate_facil_chair")
    private Integer rateFacilChair; // 시설 (좌석)
    @Column(name = "rate_facil_rest")
    private Integer rateFacilRest; // 시설 (화장실)
    @Column(name = "rate_staff_in")
    private Integer rateStaffIn; // 직원 (입장 안내)
    @Column(name = "rate_staff_ticket")
    private Integer rateStaffTicket; // 직원 (티켓 발급)
    @Column(name = "rate_event_content")
    private Integer rateEventContent; // 행사 구성 만족도
    @Column(name = "rate_event_go")
    private Integer rateEventGo; // 행사 진행 만족도
    @Column(name = "review_etc")
    private String reviewEtc; // 기타 리뷰
    @Column(name = "reg_date")
    private String regDate; // 등록일자
}
