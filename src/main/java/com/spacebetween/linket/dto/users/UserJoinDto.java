package com.spacebetween.linket.dto.users;

import com.spacebetween.linket.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserJoinDto {

    @Email
    @NotBlank(message = "이메일은 필수 입력입니다.")
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력입니다.")
    @Pattern(regexp = "^(?=.*[A-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-z\\d$@$!%*#?&]{6,20}$",
            message = "비밀번호는 6~20자리수여야 합니다. 영문, 숫자, 특수문자를 1개 이상 포함해야 합니다.")
    private String password;

    @NotBlank(message = "비밀번호 재입력은 필수 입력입니다.")
    private String passwordConfirm;

    @NotBlank
    private String userName;

    @NotBlank
    private String birthdate;

    @NotBlank
    private boolean agreement;

    @NotBlank
    private String phone;

    @NotBlank(message = "성별은 필수 입력입니다.")
    private char gender;

    private String role;

    public Users toUser(String password) {
        return Users.builder()
                .email(this.email)
                .password(password)
                .userName(this.userName)
                .birthdate(this.birthdate)
                .agreement(this.agreement)
                .gender(this.gender)
                .role(this.role)
                .build();
    }
}
