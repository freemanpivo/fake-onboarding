package com.service.onboard.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Value
@Builder
public class OnboardRequest {
    String customerDocumentId;
    LocalDate reportStartDate;
}
