package com.spacebetween.linket.dto.users;

import com.spacebetween.linket.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserJoinResponseDto {

    private String email;

    public static UserJoinResponseDto of (Users user) {
        return new UserJoinResponseDto(user.getEmail());
    }
}
