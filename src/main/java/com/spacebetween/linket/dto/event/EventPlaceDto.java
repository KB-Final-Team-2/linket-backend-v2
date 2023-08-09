package com.spacebetween.linket.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventPlaceDto {
    private String placeId; // 행사 장소 고유 아이디
}
