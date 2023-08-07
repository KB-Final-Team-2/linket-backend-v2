package com.spacebetween.linket.dto.attendance;

import com.spacebetween.linket.domain.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceEventIdDto {
    private Event event;
}
