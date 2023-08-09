package com.spacebetween.linket.dto.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventDeleteDto {
    @NotBlank
    private LocalDateTime lastUpdatedDate;
    @NotBlank
    private LocalDateTime deletedDate;
}
