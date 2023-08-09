package com.spacebetween.linket.controller;

import com.spacebetween.linket.dto.response.ResponseDto;
import com.spacebetween.linket.dto.ticket.*;
import com.spacebetween.linket.service.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Api(tags = {"티켓과 관련된 Controller"})
@RequestMapping("/api/v2/ticket")
@RestController
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @ApiOperation(value = "티켓 등록", notes = "세션의 유저 email과 티켓 시리얼 넘버를 받아서 티켓 등록", response = Map.class)
    @PostMapping(path = "/")
    public ResponseEntity registerTicket(@RequestBody @Valid TicketRegisterDto ticketRegisterDto,
                                         HttpSession session) {

        String email = (String) session.getAttribute("email");
        ticketService.registerTicket(ticketRegisterDto, email);

        return new ResponseEntity<ResponseDto>(new ResponseDto(200, "success", "티켓 등록 완료"),
                HttpStatus.OK);
    }

    @ApiOperation(value = "티켓 리스트", notes = "멤버가 등록한 티켓 전체 반환(행사명을 추가하여 반환)")
    @GetMapping("/list")
    public ResponseEntity myTicketList(HttpSession session) {

        String email = (String) session.getAttribute("email");
        List<MemberTicketDto> ticketList = ticketService.memberTicketList(email);

        return new ResponseEntity<ResponseDto>(new ResponseDto<List<MemberTicketDto>>(200, "success",
                ticketList), HttpStatus.OK);
    }

    @ApiOperation(value = "티켓 조회", notes = "멤버가 등록한 티켓 중 한 개의 티켓 정보 반환")
    @PostMapping("/search")
    public ResponseEntity<?> searchTicket(@RequestBody SearchTicketReqDto reqDto) {

        TicketDto ticketDto = ticketService.searchTicket(reqDto);

        return new ResponseEntity<>(new ResponseDto(200, "success", ticketDto)
                , HttpStatus.OK);
    }

    @ApiOperation(value = "티켓 삭제", notes = "email과 ticketId를 받아서 확인 후 삭제", response = Map.class)
    @DeleteMapping("/")
    public ResponseEntity deleteMemberTicket(@RequestBody TicketDeleteDto ticketDeleteDto, HttpSession session) {

        String email = (String) session.getAttribute("email");
        ticketService.deleteTicket(ticketDeleteDto, email);

        return new ResponseEntity<ResponseDto>(new ResponseDto(200, "success", "티켓 삭제 완료"),
                HttpStatus.OK);
    }
}
