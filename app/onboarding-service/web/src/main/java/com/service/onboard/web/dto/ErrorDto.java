package com.service.onboard.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorDto {
    private final String code;
    private final String message;
    private final List<String> fields = List.of();
}
