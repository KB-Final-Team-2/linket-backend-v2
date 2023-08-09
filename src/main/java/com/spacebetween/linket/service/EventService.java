package com.spacebetween.linket.service;

import com.spacebetween.linket.domain.Attendance;
import com.spacebetween.linket.domain.Event;
import com.spacebetween.linket.dto.attendance.AttendanceIdDto;
import com.spacebetween.linket.dto.event.*;
import com.spacebetween.linket.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    /**
     * event 등록
     */
    @Transactional
    public void createEvent(EventJoinDto eventJoinDto){
        eventRepository.save(eventJoinDto);
    }

    /**
     * event 수정
     */


    /**
     * event 삭제
     */
    @Transactional
    public void deleteById(EventIdDto eventIdDto){
        EventResponseDto eventResponseDto = eventRepository.findByEventId(eventIdDto.getEventId());
        Event eventRepository.save();
    }

    /**
     * eventId로 행사 정보 조회
     */
    @Transactional
    public EventResponseDto getEvent(EventIdDto eventIdDto) {
        return eventRepository.findByEventId(eventIdDto.getEventId());
    }

    /**
     * companyId로 등록된 모드 행사 조회
     */
    @Transactional
    public List<EventResponseDto> getAllEvents(EventCompanyIdDto eventCompanyIdDto) {
        return eventRepository.findByCompanyId(Long.valueOf(eventCompanyIdDto.getEventId()));
    }

    /**
     * eventId로 통계결과 조회
     * 등록일자, 행사기간(endDate-startDate), 행사장소, 참여인원(관람객+파트타임), 총인건비, 행사설명
     */
    @Transactional
    public EventResponseDto getEventStatus(EventIdDto eventIdDto) {
        return eventRepository.findByEventId(eventIdDto.getEventId());
    }

    /**
     * placeName으로 placeId 조회
     */
    @Transactional
    public EventResponseDto getInfo(EventPlaceDto eventPlaceDto) {
        return eventRepository.findByPlace(eventPlaceDto.getPlaceId());
    }
    /*
//hire
    registerHire
    getAllHires
    getHire
    deleteHire

//getEventStatus
    selectUsers
    selCloseEvent
    getEventIdHire
    countUser

//getInfo
    selectPlaceId

    */

}
