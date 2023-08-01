package com.spacebetween.linket.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomException extends RuntimeException {

    public final ErrorCode errorCode;
}
