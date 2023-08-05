package com.spacebetween.linket.dto.attendance;

import com.spacebetween.linket.domain.Company;
import com.spacebetween.linket.domain.Event;
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
public class AttendanceResponseDto {
    private Long id;
    private LocalDateTime attDate;
    private LocalDateTime attStartDatetime;
    private LocalDateTime attEndDatetime;
    private char attStartBnt;
    private char attEndBnt;
    private LocalDateTime regDate;
    private Users users;
    private Hire hire;
    private Company company;
    private Event event;
}
