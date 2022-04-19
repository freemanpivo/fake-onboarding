package com.service.onboard.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Value
@Builder
public class OnboardResponseDto {
    @JsonProperty("protocol")
    String onboardProtocolHash;
    @JsonProperty("processed_at")
    String processedAt;
}
