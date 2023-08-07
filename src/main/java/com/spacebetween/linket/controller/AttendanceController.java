package com.spacebetween.linket.controller;

import com.spacebetween.linket.dto.attendance.*;
import com.spacebetween.linket.dto.response.ResponseDto;
import com.spacebetween.linket.service.AttendanceService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api(tags = {"part-time 출석과 관련된 Controller"})
@RequestMapping("/api/v2/attendance")
@RestController
@RequiredArgsConstructor
public class AttendanceController {
    @Autowired
    private final AttendanceService attendanceService;

    @GetMapping("/staff/{eventId}")
    public ResponseEntity getEventIdPartTime(@RequestBody AttendanceEventIdDto attendanceEventIdDto){
        List<AttendanceResponseDto> list = attendanceService.getEventIdPartTime(attendanceEventIdDto);

        return new ResponseEntity<ResponseDto>(new ResponseDto<List<AttendanceResponseDto>>(200,"success", list),
                HttpStatus.OK);
    }

    @PostMapping("/staff/start")
    public ResponseEntity updateStartBnt(@RequestBody AttendanceStartBntDto attendanceStartBntDto){
        attendanceService.updateStartBnt(attendanceStartBntDto);

        String success = new String("success");

        return new ResponseEntity<ResponseDto>(new ResponseDto<String>(200,success, "success"),
                HttpStatus.OK);
    }

    @PostMapping("/staff/end")
    public ResponseEntity updateEndBnt(@RequestBody AttendanceEndBntDto attendanceEndBntDto){
        attendanceService.updateEndBnt(attendanceEndBntDto);

        String success = new String("success");

        return new ResponseEntity<ResponseDto>(new ResponseDto<String>(200,success, "success"),
                HttpStatus.OK);
    }

    @PostMapping("/part-time/hire")
    public ResponseEntity inquireAttendance(@RequestBody AttendanceAttCheckDto attendanceAttCheckDto, HttpSession session){
        String email = (String)session.getAttribute("email");
        attendanceAttCheckDto.setEmail(email);

        AttendanceResponseDto attendanceResponseDto = attendanceService.inquireAttendance(attendanceAttCheckDto);
        return new ResponseEntity<ResponseDto>(new ResponseDto<AttendanceResponseDto>(200,"success", attendanceResponseDto),
                HttpStatus.OK);
    }

    @PostMapping("/part-time/start")
    public ResponseEntity updateStartWork(@RequestBody AttendanceIdDto attendanceIdDto){
        attendanceService.updateStartWork(attendanceIdDto);

        return new ResponseEntity<ResponseDto>(new ResponseDto<String>(200,new String("success"),"success"),HttpStatus.OK);
    }

    @PostMapping("/part-time/end")
    public ResponseEntity updateEndWork(@RequestBody AttendanceIdDto attendanceIdDto){
        attendanceService.updateEndWork(attendanceIdDto);

        return new ResponseEntity<ResponseDto>(new ResponseDto<String>(200,new String("success"),"success"),HttpStatus.OK);
    }

    @PostMapping("/part-time/list")
    public ResponseEntity getAllPartTime(@RequestBody AttendanceHireIdDto attendanceHireIdDto){
        List<AttendanceResponseDto> list = attendanceService.getAllPartTime(attendanceHireIdDto);

        return new ResponseEntity<ResponseDto>(new ResponseDto<List<AttendanceResponseDto>>(200,"success",list),HttpStatus.OK);
    }

    @PostMapping("/myAtt")
    public ResponseEntity getHirePartTime(@RequestBody AttendanceHireInquireDto attendanceHireInquireDto, HttpSession session){
        String email = (String)session.getAttribute("email");
        attendanceHireInquireDto.setEmail(email);

        AttendanceResponseDto attendanceResponseDto = attendanceService.getHirePartTime(attendanceHireInquireDto);

        return new ResponseEntity<ResponseDto>(new ResponseDto<AttendanceResponseDto>(200,"success",attendanceResponseDto), HttpStatus.OK);
    }
}
