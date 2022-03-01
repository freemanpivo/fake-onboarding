package com.service.customer.domain.exception;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException{
    private final String message;
    private final String code;
    private static final String DEFAULT_MESSAGE = "invalid query params";
    private static final String DEFAULT_CODE = "400";

    public BadRequestException() {
        this.message = DEFAULT_MESSAGE;
        this.code = DEFAULT_CODE;
    }
}
