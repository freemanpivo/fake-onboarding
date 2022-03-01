package com.service.customer.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Value
@Builder
public class Customer {
    String id;
    String completeName;
    String personalDocumentIdentifierNumber;
    String birthDate;
    LocalDateTime onboardingDate = LocalDateTime.now();
}
