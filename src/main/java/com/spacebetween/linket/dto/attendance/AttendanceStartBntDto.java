package com.spacebetween.linket.dto.attendance;

import com.spacebetween.linket.domain.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceStartBntDto {
    private char attStartBnt;
    private Event event;
    private LocalDateTime attDate;
}
