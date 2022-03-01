package com.service.customer.domain.exception;

import lombok.Getter;

@Getter
public class UnprocessableEntityException extends RuntimeException {
    private final String code;
    private final String message;

    private static final String DEFAULT_MESSAGE = "[id] must be in UUID format or [document_id] must have valid pattern.";
    private static final String DEFAULT_CODE = "422";

    public UnprocessableEntityException() {
        this.message = DEFAULT_MESSAGE;
        this.code = DEFAULT_CODE;
    }
}
