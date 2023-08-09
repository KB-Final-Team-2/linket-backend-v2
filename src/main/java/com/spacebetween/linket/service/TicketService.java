package com.spacebetween.linket.service;

import com.spacebetween.linket.domain.Ticket;
import com.spacebetween.linket.domain.Users;
import com.spacebetween.linket.dto.ticket.*;
import com.spacebetween.linket.exception.CustomException;
import com.spacebetween.linket.repository.TicketRepository;
import com.spacebetween.linket.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.spacebetween.linket.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UsersRepository usersRepository;

    /**
     * 티켓 등록
     */
    @Transactional
    public void registerTicket(TicketRegisterDto ticketRegisterDto, String email) {

        // 1. 티켓 사용여부 체크
        if (!checkTicket(ticketRegisterDto.getSerialNum())) {
            throw new CustomException(ALREADY_SAVED_TICKET);
        }

        // 2. 세션의 이메일 정보 가져온 후 티켓 등록
        Users user = usersRepository.findByUserEmail(email)
                .orElseThrow(() -> new CustomException(USER_NOT_FOUND));
        Ticket ticket = ticketRegisterDto.toEntity(user);
        saveTicket(ticket);
    }

    /**
     * 등록된 티켓인지 확인 (ticket_req 컬럼값이 "N"인 경우에만 등록 가능)
     */
    public boolean checkTicket(String serialNum) {

        Ticket targetTicket = ticketRepository.findBySerialNum(serialNum)
                .orElseThrow(() -> new CustomException(TICKET_NOT_FOUND));

        if (targetTicket.getTicketReg().equals("Y")) {
            return false; // 등록 불가
        } else {
            return true; // 등록 가능
        }
    }

    /**
     * 티켓 저장
     */
    private void saveTicket(Ticket ticket) {
        try {
            ticketRepository.save(ticket);
        } catch (RuntimeException e) {
            throw new CustomException(INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 본인의 등록된 티켓 전체 조회
     */
    public List<MemberTicketDto> memberTicketList(String email) {

        return ticketRepository.getMyTickets(email);
    }

    /**
     * 선택한 티켓 조회
     */
    @Transactional
    public TicketDto searchTicket(SearchTicketReqDto reqDto) {

        Ticket ticket = ticketRepository.findById(reqDto.getTicketId())
                .orElseThrow(() -> new CustomException(TICKET_NOT_FOUND));

        return new TicketDto().builder()
                .id(ticket.getId())
                .serialNum(ticket.getSerialNum())
                .seat(ticket.getSeat())
                .build();
    }


    /**
     * 티켓 삭제
     */
    @Transactional
    public void deleteTicket(TicketDeleteDto ticketDeleteDto, String email) {
        Ticket ticket = ticketRepository.findById(ticketDeleteDto.getTicketId())
                .orElseThrow(() -> new CustomException(TICKET_NOT_FOUND));

        Users user = usersRepository.findByUserEmail(email)
                .orElseThrow(() -> new CustomException(USER_NOT_FOUND));
        // 연관관계 삭제
        user.getTickets().remove(ticket);
    }
}
