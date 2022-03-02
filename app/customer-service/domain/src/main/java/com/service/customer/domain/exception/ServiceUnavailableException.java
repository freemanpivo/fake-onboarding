package com.service.customer.domain.exception;

import lombok.Getter;

@Getter
public class ServiceUnavailableException extends RuntimeException {
    private final String code;
    private final String message;

    private static final String DEFAULT_MESSAGE = "an error occurred processing your request.";
    private static final String DEFAULT_CODE = "503";

    public ServiceUnavailableException() {
        this.message = DEFAULT_MESSAGE;
        this.code = DEFAULT_CODE;
    }
}
