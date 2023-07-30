package com.spacebetween.linket.dto;

import com.spacebetween.linket.domain.Attendance;
import com.spacebetween.linket.domain.Company;
import com.spacebetween.linket.domain.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserInfoDto {
    private Long id;
    private String email;
    private String password;
    private String userName;
    private String birthdate;
    private boolean agreement;
    private String phone;
    private char gender;
    private String role;
    private LocalDateTime withdrawDate;
    private char enabled;
    private LocalDateTime regDate;
    private LocalDateTime lastUpdatedDate;
    private Company company;
    private List<Attendance> attendances;
    private List<Ticket> tickets;
}
