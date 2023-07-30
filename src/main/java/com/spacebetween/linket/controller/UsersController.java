package com.spacebetween.linket.controller;

import com.spacebetween.linket.domain.Users;
import com.spacebetween.linket.dto.UserInfoDto;
import com.spacebetween.linket.response.ResponseDto;
import com.spacebetween.linket.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.nio.charset.Charset;
import java.util.HashMap;

@RequestMapping("/api/users")
@RestController
@RequiredArgsConstructor
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/")
    public ResponseEntity userInfo(HttpSession session){
        //session에서 얻어온 email 정보
        String email = (String)session.getAttribute("email");

        Users user = usersService.getUserByEmail(email);
        UserInfoDto userInfoDto = UserInfoDto.builder().id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .userName(user.getUserName())
                .birthdate(user.getBirthdate())
                .agreement(user.isAgreement())
                .phone(user.getPhone())
                .gender(user.getGender())
                .role(user.getRole())
                .withdrawDate(user.getWithdrawDate())
                .enabled(user.getEnabled())
                .regDate(user.getRegDate())
                .lastUpdatedDate(user.getLastUpdatedDate())
                .company(user.getCompany())
                .attendances(user.getAttendances())
                .tickets(user.getTickets()).build();

        return new ResponseEntity<ResponseDto>(new ResponseDto(200,"success", userInfoDto), HttpStatus.OK);
    }

    @PostMapping("/{password}")
    public ResponseEntity checkUserPwd(@PathVariable String password, HttpSession session){
        //session에서 얻어온 password 정보
        String sessionPassword = (String)session.getAttribute("password");

        if(password.equals(sessionPassword)){ // password 확인 성공
            String success = new String("success");

            return new ResponseEntity<ResponseDto>(new ResponseDto(200,"success",success), HttpStatus.OK);
        }
        else {
            String fail = new String("fail");

            return new ResponseEntity<ResponseDto>(new ResponseDto(400,"success",fail), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/phone/{phone}")
    public ResponseEntity updateUserPhone(@PathVariable String phone, HttpSession session) throws Exception{
        String email = (String)session.getAttribute("email");

        usersService.updateUserPhone(email,phone);

        return new ResponseEntity<ResponseDto>(new ResponseDto(200,new String("success"),"success"), HttpStatus.OK);
    }

    @PostMapping("/password/{password}")
    public ResponseEntity updateUserPassword(@PathVariable String password, HttpSession session) throws Exception{
        String email = (String)session.getAttribute("email");

        usersService.updateUserPassword(email, password);

        return new ResponseEntity<ResponseDto>(new ResponseDto(200, new String("success"),"success"), HttpStatus.OK);
    }
}
