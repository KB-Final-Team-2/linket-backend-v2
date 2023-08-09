package com.spacebetween.linket.repository;

import com.spacebetween.linket.domain.Ticket;
import com.spacebetween.linket.dto.ticket.MemberTicketDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findBySerialNum(String serialNum);

    @Query("SELECT new com.spacebetween.linket.dto.ticket.MemberTicketDto(t.id, e.eventName)" +
            " FROM Ticket t " +
            "JOIN t.event e JOIN t.users u WHERE u.email = :email")
    List<MemberTicketDto> getMyTickets(@Param("email") String email);
}
