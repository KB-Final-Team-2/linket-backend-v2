package com.spacebetween.linket.dto.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserUpdatePasswordDto {

    @NotBlank(message = "비밀번호는 필수 입력입니다.")
    @Pattern(regexp = "^(?=.*[A-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-z\\d$@$!%*#?&]{6,20}$",
            message = "비밀번호는 6~20자리수여야 합니다. 영문, 숫자, 특수문자를 1개 이상 포함해야 합니다.")
    private String password;

    @NotBlank(message = "비밀번호 재입력은 필수 입력입니다.")
    private String passwordConfirm;
}
