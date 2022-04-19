package com.service.onboard.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Value
@Builder
public class OnboardRequestDto {
    @JsonProperty("customer_document_id")
    String customerDocumentId;
    @JsonProperty("report_start_date")
    LocalDate reportStartDate;
}
