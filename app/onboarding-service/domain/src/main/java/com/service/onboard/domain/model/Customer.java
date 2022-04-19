package com.service.onboard.domain.model;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Value
@Builder
public class Customer {
    String id;
    String completeName;
    String documentId;
    String email;
    String birthdate;
}
