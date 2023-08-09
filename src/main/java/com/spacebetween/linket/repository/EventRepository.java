package com.spacebetween.linket.repository;

import com.spacebetween.linket.domain.Event;
import com.spacebetween.linket.dto.event.EventResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    /**
     * eventId로 행사 정보 조회 :: getEvent Long eventId
     */
    EventResponseDto findByEventId(Long eventId);

    /**
     * companyId로 등록된 모드 행사 조회 :: getAllEvents Long eventCompanyId
     */
    List<EventResponseDto> findByCompanyId(Long companyId);

    /**
     * placeName으로 좌표 조회 :: getInfo String placeName
     */
    EventResponseDto findByPlace(String placeName);



    //공고
//    getHire Long hireId
//    getAllHires Long hireEventId

}
