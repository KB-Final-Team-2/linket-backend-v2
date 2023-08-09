package com.spacebetween.linket.dto.event;

import com.spacebetween.linket.domain.Company;
import com.spacebetween.linket.domain.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventCompanyIdDto {
    private Company company;
    private Long eventId;
}
