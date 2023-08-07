package com.spacebetween.linket.dto.attendance;

import com.spacebetween.linket.domain.Hire;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceHireInquireDto {
    private String email;
    private Hire hire;

    public void setEmail(String email){
        this.email = email;
    }
}
