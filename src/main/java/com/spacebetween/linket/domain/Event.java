package com.spacebetween.linket.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id; // 행사 아이디 자동생성

    @Column(nullable = false)
    private String eventName; // 행사명

    @Column(nullable = false)
    private String eventType; // 행사 종류

    @Column(nullable = false)
    private String place; // 행사 장소

    @Column(nullable = false)
    private String placeId; // 행사 장소 고유 아이디

    @Column(nullable = false)
    private String eventImage; // 행사 이미지

    @Column(nullable = false)
    private String eventInq; // 행사 대표문의처

    @Column(nullable = false)
    private String eventDesc; // 행사 설명

    //    @Column(nullable = false)
    @ColumnDefault("Y")
    private String eventStatus; // 진행 여부 (default: 'Y')

    @Column(nullable = false)
    private String startDate; // 행사 시작일자

    @Column(nullable = false)
    private String endDate; // 행사 종료일자

    @CreatedDate
    @Column(updatable = false)
    @DateTimeFormat
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

    //    public void registerEvent(String password) {
//        this.password = password;
//    }
//    public static Event registerEvent(Company eventCompanyId, String eventName, String eventType, String place, String placeId, String eventImage, String eventInq, String eventDesc, String eventStatus, String startDate, String endDate, LocalDateTime regDate, LocalDateTime lastUpdatedDate, LocalDateTime deletedDate, String link) {
//        Event event = Event.builder()
//                .company(eventCompanyId)
//                .eventName(eventName)
//                .eventType(eventType)
//                .place(place)
//                .placeId(placeId)
//                .eventImage(eventImage)
//                .eventInq(eventInq)
//                .eventDesc(eventDesc)
//                .eventStatus(eventStatus)
//                .startDate(startDate)
//                .endDate(endDate)
//                .regDate(regDate)
//                .lastUpdatedDate(lastUpdatedDate)
//                .deletedDate(deletedDate)
//                .link(link)
//                .build();
//        return event;
//    }
//
//
//
//    public static Event updateEvent(String eventName, String eventType, String place, String placeId, String eventImage, String eventInq, String eventDesc, String eventStatus, String startDate, String endDate, LocalDateTime lastUpdatedDate, LocalDateTime deletedDate, String link) {
//        Event event = Event.builder()
//                .eventName(eventName)
//                .eventType(eventType)
//                .place(place)
//                .placeId(placeId)
//                .eventImage(eventImage)
//                .eventInq(eventInq)
//                .eventDesc(eventDesc)
//                .eventStatus(eventStatus)
//                .startDate(startDate)
//                .endDate(endDate)
//                .lastUpdatedDate(lastUpdatedDate)
//                .deletedDate(deletedDate)
//                .link(link)
//                .build();
//        return event;
//    }
//
    public void deleteEvent(LocalDateTime lastUpdatedDate, LocalDateTime deletedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
        this.deletedDate = deletedDate;
    }
}
