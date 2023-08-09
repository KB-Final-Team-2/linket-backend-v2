package com.spacebetween.linket.dto.event;

import com.spacebetween.linket.domain.Company;
import com.spacebetween.linket.domain.Hire;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class EventJoinDto {
    @NotBlank
    private String eventName; // 행사
    @NotBlank
    private String eventType; // 행사 종류
    @NotBlank
    private String place; // 행사 장소
    @NotBlank
    private String placeId; // 행사 장소 고유 아이디
    @NotBlank

    private String eventImage; // 행사 이미지
    @NotBlank
    private String eventInq; // 행사 대표문의처
    @NotBlank
    private String eventDesc; // 행사 설명
    @NotBlank
    private String eventStatus; // 진행 여부 (default: 'Y')
    @NotBlank
    private String startDate; // 행사 시작일자
    @NotBlank
    private String endDate; // 행사 종료일자
    private LocalDateTime regDate; // 등록일자
    private LocalDateTime lastUpdatedDate; // 수정일자
    private String link; // 링크

}
