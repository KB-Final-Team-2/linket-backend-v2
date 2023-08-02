package com.spacebetween.linket.controller;

import com.spacebetween.linket.domain.Users;
import com.spacebetween.linket.dto.users.UserPhoneUpdateDto;
import com.spacebetween.linket.dto.users.UserResponseDto;
import com.spacebetween.linket.dto.response.ResponseDto;
import com.spacebetween.linket.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Api(tags = {"회원프로필과 관련된 Controller"})
@RequestMapping("/api/v2/users")
@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @ApiOperation(value = "회원 프로필 조회", notes = "회원 프로필을 반환")
    @GetMapping("/")
    public ResponseEntity userInfo(HttpSession session){

        // session에서 얻어온 email 정보
        String email = (String)session.getAttribute("email");

        Users user = usersService.findByUserEmail(email);

        UserResponseDto userInfo = UserResponseDto.builder()
                .userId(user.getId())
                .email(user.getEmail())
                .userName(user.getUserName())
                .birthdate(user.getBirthdate())
                .phone(user.getPhone())
                .gender(user.getGender())
                .role(user.getRole())
                .company(user.getCompany())
                .build();

        return new ResponseEntity<ResponseDto>(new ResponseDto<UserResponseDto>(200,"success", userInfo),
                HttpStatus.OK);
    }

    @ApiOperation(value = "비밀번호 확인")
    @PostMapping("/{password}")
    public ResponseEntity checkUserPwd(@PathVariable String password, HttpSession session){

        // session에서 얻어온 password 정보
        String sessionPassword = (String)session.getAttribute("password");

        if(password.equals(sessionPassword)){ // password 확인 성공
            String success = new String("success");

            return new ResponseEntity<ResponseDto>(new ResponseDto(200,"success",success),
                    HttpStatus.OK);
        }
        else {
            String fail = new String("fail");

            return new ResponseEntity<ResponseDto>(new ResponseDto(400,"success",fail),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "회원 전화번호 수정")
    @ApiResponses({
            @ApiResponse(code = 200, message = "회원 전화번호 수정 완료")
    })
    @PutMapping("/phone")
    public ResponseEntity updateUserPhone(@Valid UserPhoneUpdateDto userPhoneUpdateDto, HttpSession session) throws Exception {
        String email = (String)session.getAttribute("email");

        usersService.updateUserPhone(email, userPhoneUpdateDto);

        return new ResponseEntity<ResponseDto>(new ResponseDto(200,new String("success"),"success"),
                HttpStatus.OK);
    }


}


