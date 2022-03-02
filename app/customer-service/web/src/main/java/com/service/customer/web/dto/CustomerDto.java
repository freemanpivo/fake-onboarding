package com.service.customer.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Value
@Builder
public class CustomerDto {
    @JsonProperty("id")
    String id;
    @JsonProperty("complete_name")
    String completeName;
    @JsonProperty("document_number_identifier")
    String personalDocumentIdentifierNumber;
    @JsonProperty("email_address")
    String email;
    @JsonProperty("birth_date")
    String birthDate;
}
