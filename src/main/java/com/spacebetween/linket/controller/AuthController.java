package com.spacebetween.linket.controller;

import com.spacebetween.linket.domain.Users;
import com.spacebetween.linket.dto.response.ResponseDto;
import com.spacebetween.linket.dto.users.UserJoinDto;
import com.spacebetween.linket.dto.users.UserLoginDto;
import com.spacebetween.linket.dto.users.UserUpdatePasswordDto;
import com.spacebetween.linket.exception.CustomException;
import com.spacebetween.linket.exception.CustomValidationException;
import com.spacebetween.linket.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static com.spacebetween.linket.exception.ErrorCode.NOT_EQUAL_PASSWORD;

@Slf4j
@Api(tags = {"회원가입, 로그인, 로그아웃과 관련된 Controller"})
@RequestMapping("/api/v2/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @ApiOperation(value = "회원가입")
    @ApiResponses({
            @ApiResponse(code = 200, message = "회원가입 성공"),
            @ApiResponse(code = 400, message = "잘못된 접근"),
            @ApiResponse(code = 409, message = "이미 존재하는 이메일"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    public ResponseEntity<?> register(@RequestBody @Valid UserJoinDto userJoinDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            throw new CustomValidationException("유효성 검사 실패", errorMap);
        } else {
            if (userJoinDto.getPassword().equals(userJoinDto.getPasswordConfirm())) {
                throw new CustomException(NOT_EQUAL_PASSWORD);
            }
            return new ResponseEntity<>(new ResponseDto(200, "회원가입 성공",
                    authService.register(userJoinDto)), HttpStatus.OK);
        }
    }

    @ApiOperation(value = "로그인")
    @ApiResponses({
            @ApiResponse(code = 200, message = "로그인 성공"),
            @ApiResponse(code = 400, message = "비밀번호 오류"),
            @ApiResponse(code = 404, message = "존재하지 않은 이메일입니다."),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PostMapping("/login")
    public ResponseEntity<?> login(HttpServletRequest request, @RequestBody UserLoginDto userLoginDto) {
        Users user = authService.login(userLoginDto);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", user);
            session.setMaxInactiveInterval(60 * 30);
        }

        return new ResponseEntity<ResponseDto>(new ResponseDto<>(200, "로그인 성공",
                user), HttpStatus.OK);
    }

    @ApiOperation(value = "로그아웃")
    @ApiResponses({
            @ApiResponse(code = 200, message = "로그아웃 성공"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/logout")
    public ResponseEntity logout(HttpServletRequest request) {
        log.info("로그아웃 성공");
        HttpSession session = request.getSession();
        session.invalidate();

        return new ResponseEntity<>(new ResponseDto<Object>(200, "로그아웃 완료", null),
                HttpStatus.OK);
    }

    @ApiOperation(value = "비밀번호 변경")
    @PutMapping("/password")
    public ResponseEntity updatePassword(@RequestBody @Valid UserUpdatePasswordDto updatePasswordDto,
                                         HttpSession session) throws Exception{
        String email = (String)session.getAttribute("email");

        authService.updateUserPassword(email, updatePasswordDto.getPassword(), updatePasswordDto.getPasswordConfirm());

        return new ResponseEntity<ResponseDto>(new ResponseDto(200, "비밀번호 변경 완료","success"),
                HttpStatus.OK);
    }
}
