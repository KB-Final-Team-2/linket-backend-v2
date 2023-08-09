package com.spacebetween.linket.dto.ticket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TicketDto {

    private Long id;
    private String serialNum;
    private String seat;
}
