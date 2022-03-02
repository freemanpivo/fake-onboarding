package com.service.customer.web.exception;

import com.service.customer.domain.exception.BadRequestException;
import com.service.customer.domain.exception.NotFoundException;
import com.service.customer.domain.exception.ServiceUnavailableException;
import com.service.customer.domain.exception.UnprocessableEntityException;
import com.service.customer.web.dto.CollectionErrorResponse;
import com.service.customer.web.dto.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ApiExceptionFlow extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    protected ResponseEntity<Object> handleBadRequest(BadRequestException ex, WebRequest request) {
        final var responseObject = new ErrorDto(ex.getCode(), ex.getMessage());
        final var responseBody = new CollectionErrorResponse(List.of(responseObject));

        return handleExceptionInternal(ex, responseBody, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleUnprocessableEntity(UnprocessableEntityException ex, WebRequest request) {
        final var responseObject = new ErrorDto(ex.getCode(), ex.getMessage());
        final var responseBody = new CollectionErrorResponse(List.of(responseObject));

        return handleExceptionInternal(ex, responseBody, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleNotFound(NotFoundException ex, WebRequest request) {
        final var responseObject = new ErrorDto(ex.getCode(), ex.getMessage());
        final var responseBody = new CollectionErrorResponse(List.of(responseObject));

        return handleExceptionInternal(ex, responseBody, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleServiceUnavailable(ServiceUnavailableException ex, WebRequest request) {
        final var responseObject = new ErrorDto(ex.getCode(), ex.getMessage());
        final var responseBody = new CollectionErrorResponse(List.of(responseObject));

        return handleExceptionInternal(ex, responseBody, new HttpHeaders(), HttpStatus.SERVICE_UNAVAILABLE, request);
    }
}
