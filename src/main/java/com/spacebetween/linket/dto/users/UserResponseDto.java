package com.spacebetween.linket.dto.users;

import com.spacebetween.linket.domain.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserResponseDto {
    private Long userId;
    private String email;
    private String userName;
    private String birthdate;
    private String phone;
    private char gender;
    private String role;
    private Company company;
}

