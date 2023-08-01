package com.spacebetween.linket.dto.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPhoneUpdateDto {

    @NotBlank(message = "전화번호는 필수 입력입니다.")
    @Size(min = 8, max = 15)
    private String phone;
}
