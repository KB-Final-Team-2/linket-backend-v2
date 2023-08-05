package com.spacebetween.linket.dto.attendance;

import com.spacebetween.linket.domain.Hire;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceAttCheckDto {
    private String email;
    private Hire hire;
    private LocalDateTime attDate;

    public void setEmail(String email){
        this.email = email;
    }
}
