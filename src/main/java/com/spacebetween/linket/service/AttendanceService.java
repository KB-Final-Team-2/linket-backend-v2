package com.spacebetween.linket.service;

import com.spacebetween.linket.domain.Attendance;
import com.spacebetween.linket.dto.attendance.*;
import com.spacebetween.linket.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    /**
     * Staff가 해당 eventId에 대해 Part 직원들의 출근 여부를 조회
     */
    @Transactional
    public List<AttendanceResponseDto> getEventIdPartTime(AttendanceEventIdDto attendanceEventIdDto){
        return attendanceRepository.findByEventId(attendanceEventIdDto.getEvent().getId());
    }

    /**
     * Staff가 해당 event에 해당하는 part-time에 출근 버튼을 활성화 / 비활성화
     */
    @Transactional
    public void updateStartBnt(AttendanceStartBntDto attendanceStartBntDto){
        List<AttendanceResponseDto> list = attendanceRepository.findByEventIdAndAttDate(attendanceStartBntDto.getEvent().getId(), attendanceStartBntDto.getAttDate());

        for(AttendanceResponseDto attendanceResponseDto : list) {
            attendanceResponseDto.setAttStartBnt(attendanceStartBntDto.getAttStartBnt());
        }
    }

    /**
     * Staff가 해당 event에 해당하는 part-time에 퇴근 버튼을 활성화 / 비활성화
     */
    @Transactional
    public void updateEndBnt(AttendanceEndBntDto attendanceEndBntDto){
        List<AttendanceResponseDto> list = attendanceRepository.findByEventIdAndAttDate(attendanceEndBntDto.getEvent().getId(), attendanceEndBntDto.getAttDate());

        for(AttendanceResponseDto attendanceResponseDto : list) {
            attendanceResponseDto.setAttEndBnt(attendanceEndBntDto.getAttEndBnt());
        }
    }

    /**
     * Part 직원이 자신의 출근 현황을 조회합니다.
     */
    @Transactional
    public AttendanceResponseDto inquireAttendance(AttendanceAttCheckDto attendanceAttCheckDto){
        AttendanceResponseDto attendanceResponseDto = attendanceRepository.findByEmailAndAttDateAndHireId(attendanceAttCheckDto.getEmail(), attendanceAttCheckDto.getAttDate(), attendanceAttCheckDto.getHire().getId());
        return attendanceResponseDto;
    }

    /**
     * <Part 직원이 출근 확인 버튼을 눌러 근무를 시작합니다.
     */
    @Transactional
    public void updateStartWork(AttendanceIdDto attendanceIdDto){
        Optional<Attendance> optionalAtt = attendanceRepository.findById(attendanceIdDto.getId());
        Attendance attendance = (Attendance)optionalAtt.get();
        attendance.setAttStartDatetime(LocalDateTime.now());
    }

    /**
     * <Part 직원이 퇴근 확인 버튼을 눌러 근무를 시작합니다.
     */
    @Transactional
    public void updateEndWork(AttendanceIdDto attendanceIdDto){
        Optional<Attendance> optionalAtt = attendanceRepository.findById(attendanceIdDto.getId());
        Attendance attendance = (Attendance)optionalAtt.get();
        attendance.setAttEndDatetime(LocalDateTime.now());
    }

    /**
     * 한 공고에 대한 모든 part-time list 가져온다.
     */
    @Transactional
    public List<AttendanceResponseDto> getAllPartTime(AttendanceHireIdDto attendanceHireIdDto){
        return attendanceRepository.findByHireId(attendanceHireIdDto.getHire().getId());
    }

    /**
     * part - time 자신이 선택한 공고의 Attendance를 조회하는 기능
     */
    @Transactional
    public AttendanceResponseDto getHirePartTime(AttendanceHireInquireDto attendanceHireInquireDto){
        return attendanceRepository.findByEmailAndHireId(attendanceHireInquireDto.getEmail(), attendanceHireInquireDto.getHire().getId());
    }
}
