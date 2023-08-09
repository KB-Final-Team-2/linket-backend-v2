package com.spacebetween.linket.dto.event;

import com.spacebetween.linket.domain.Company;
import com.spacebetween.linket.domain.Hire;
import com.spacebetween.linket.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventIdDto {
    private Long eventId; // 행사 아이디 PK

//    private String eventName; // 행사
//    private String eventType; // 행사 종류
//    private String place; // 행사 장소
//    private String placeId; // 행사 장소 고유 아이디
//    private String eventImage; // 행사 이미지
//    private String eventInq; // 행사 대표문의처
//    private String eventDesc; // 행사 설명
//    private String eventStatus; // 진행 여부 (default: 'Y')
//    private String startDate; // 행사 시작일자
//    private String endDate; // 행사 종료일자
//    private LocalDateTime regDate; // 등록일자
//    private LocalDateTime lastUpdatedDate; // 수정일자
//    private LocalDateTime deletedDate; // 삭제일자
//    private String link; // 링크
//
//    private Company company;
//    private Hire hire;
//    private Users users;


}
