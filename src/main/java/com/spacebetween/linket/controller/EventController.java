package com.spacebetween.linket.controller;

import com.spacebetween.linket.dto.event.EventCompanyIdDto;
import com.spacebetween.linket.dto.event.EventIdDto;
import com.spacebetween.linket.dto.event.EventPlaceDto;
import com.spacebetween.linket.dto.event.EventResponseDto;
import com.spacebetween.linket.dto.response.ResponseDto;
import com.spacebetween.linket.service.EventService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"event와 관련된 Controller"})
@RequestMapping("/api/v2/attendance")
@RestController
@RequiredArgsConstructor
public class EventController {
    @Autowired
    private final EventService eventService;


    @PostMapping("/event/detail")
    public ResponseEntity getEvent(@RequestBody EventIdDto eventIdDto) {
        EventResponseDto eventResponseDto = eventService.getEvent(eventIdDto);

        return new ResponseEntity<ResponseDto>(new ResponseDto<EventResponseDto>(200,
                "success", eventResponseDto), HttpStatus.OK);
    }

    @PostMapping("/event/list")
    public List<ResponseEntity> getAllEvents(@RequestBody EventCompanyIdDto eventCompanyIdDto) {
        List<EventResponseDto> list = eventService.getAllEvents(eventCompanyIdDto);

        return (List<ResponseEntity>) new ResponseEntity<ResponseDto>(new ResponseDto<List<EventResponseDto>>(200,
                "success", list), HttpStatus.OK);
    }

    @PostMapping("/event/map")
    public ResponseEntity getInfo(@RequestBody EventPlaceDto eventPlaceDto) {
        EventResponseDto eventResponseDto = eventService.getInfo(eventPlaceDto);

        return new ResponseEntity<ResponseDto>(new ResponseDto<EventResponseDto>(200,
                "success", eventResponseDto), HttpStatus.OK);
    }

    @PostMapping("/event/stats")
    public ResponseEntity getEventStatus(@RequestBody EventIdDto eventIdDto) {
        EventResponseDto eventResponseDto = eventService.getEvent(eventIdDto);

        return new ResponseEntity<ResponseDto>(new ResponseDto<EventResponseDto>(200,
                "success", eventResponseDto), HttpStatus.OK);

    }
}
