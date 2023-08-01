package com.spacebetween.linket.service;

import com.spacebetween.linket.domain.Users;
import com.spacebetween.linket.dto.users.UserJoinDto;
import com.spacebetween.linket.dto.users.UserJoinResponseDto;
import com.spacebetween.linket.dto.users.UserLoginDto;
import com.spacebetween.linket.exception.CustomException;
import com.spacebetween.linket.exception.ErrorCode;
import com.spacebetween.linket.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.spacebetween.linket.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원가입
     */
    @Transactional
    public UserJoinResponseDto register(UserJoinDto userJoinDto) {
        if (usersRepository.existsByUserEmail(userJoinDto.getEmail())) {
            throw new CustomException(ALREADY_SAVED_USER);
        }

        Users user = userJoinDto.toUser(userJoinDto.getPassword());
        Users saveUser = usersRepository.save(user);

        return UserJoinResponseDto.of(saveUser);
    }

    /**
     * 로그인
     */
    @Transactional
    public Users login(UserLoginDto userLoginDto) throws RuntimeException {
        // 1. Login ID/PW를 기반으로 AuthenticationToken 생성
        UsernamePasswordAuthenticationToken authenticationToken = userLoginDto.toAuthentication();

        // 회원 정보 및 비밀번호 조회
        Users user = usersRepository.findByUserEmail(userLoginDto.getEmail()).orElseThrow(() ->
         new CustomException(USER_NOT_FOUND));
        String encodedPassword = (user == null) ? "" : user.getPassword();

        // 2. 회원 정보 및 비밀번호 체크
        if (user == null || passwordEncoder.matches(userLoginDto.getPassword(), encodedPassword) == false) {
            throw new CustomException(NOT_EQUAL_PASSWORD);
        }

        // 3. 회원 응답 객체에서 비밀번호 제거 후 회원 정보 리턴

        return user;
    }

    /**
     * 로그아웃은 세션에서 처리
     */
//    @Transactional
//    public void logout

    /**
     * 비밀번호 변경
     */
    public void updateUserPassword(String email, String password, String passwordConfirm){
        Users user = usersRepository.findByUserEmail(email).orElseThrow(() -> new CustomException(USER_NOT_FOUND));

        if (passwordEncoder.matches(password, passwordConfirm) == false) {
            throw new CustomException(NOT_EQUAL_PASSWORD);
        }
        String encodedPassword = passwordEncoder.encode(password);
        user.updatePassword(encodedPassword);

//        usersRepository.save(user);
    }
}
