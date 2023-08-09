package com.spacebetween.linket.dto.event;

import com.spacebetween.linket.domain.Company;
import com.spacebetween.linket.domain.Hire;
import com.spacebetween.linket.domain.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventResponseDto {

    private Long eventId; // 행사 아이디 자동생성
    private String eventName; // 행사
    private String eventType; // 행사 종류
    private String place; // 행사 장소
    private String placeId; // 행사 장소 고유 아이디
    private String eventImage; // 행사 이미지
    private String eventInq; // 행사 대표문의처
    private String eventDesc; // 행사 설명
    private String eventStatus; // 진행 여부 (default: 'Y')
    private String startDate; // 행사 시작일자
    private String endDate; // 행사 종료일자
    private LocalDateTime regDate; // 등록일자
    private LocalDateTime lastUpdatedDate; // 수정일자
    private LocalDateTime deletedDate; // 삭제일자
    private String link; // 링크

    private Company company;
    private Hire hire;


}
