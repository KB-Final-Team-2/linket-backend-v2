package com.spacebetween.linket.repository;

import com.spacebetween.linket.domain.Attendance;
import com.spacebetween.linket.dto.attendance.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    /**
     *  eventId에 해당하는 출결 모두 조회
     */
    List<AttendanceResponseDto> findByEventId(Long eventId);

    /**
     *  eventId, attDate에 해당하는 출결 모두 조회
     */
    List<AttendanceResponseDto> findByEventIdAndAttDate(Long eventId, LocalDateTime attDate);

    /**
     * email, AttDate, HireId를 통해 자신의 출석 현황을 확인
     */
    AttendanceResponseDto findByEmailAndAttDateAndHireId(String email, LocalDateTime attDate, Long hireId);


    /**
     * hire_id에 해당하는 출결 모두 조회
     */
    List<AttendanceResponseDto> findByHireId(Long hireId);

    /**
     * hire_id, email에 해당하는 출결 조회
     */
    AttendanceResponseDto findByEmailAndHireId(String email,Long hireId);
}
