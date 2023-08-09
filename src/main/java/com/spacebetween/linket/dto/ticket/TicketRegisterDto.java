package com.spacebetween.linket.dto.ticket;

import com.spacebetween.linket.domain.Ticket;
import com.spacebetween.linket.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketRegisterDto {

    @NotBlank(message = "티켓 시리얼 번호는 필수 입력입니다.")
    private String serialNum;

    public Ticket toEntity(Users user) {

        return Ticket.builder()
                .ticketReg("Y")
                .users(user)
                .build();
    }
}
