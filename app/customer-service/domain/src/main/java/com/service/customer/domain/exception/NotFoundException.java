package com.service.customer.domain.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private final String code;
    private final String message;

    private static final String DEFAULT_MESSAGE = "the specified resource was not found.";
    private static final String DEFAULT_CODE = "404";

    public NotFoundException() {
        this.message = DEFAULT_MESSAGE;
        this.code = DEFAULT_CODE;
    }
}
