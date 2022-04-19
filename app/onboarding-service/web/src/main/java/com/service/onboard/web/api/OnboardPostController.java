package com.service.onboard.web.api;

import com.service.onboard.web.dto.CollectionResponse;
import com.service.onboard.web.dto.OnboardRequestDto;
import com.service.onboard.web.dto.OnboardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OnboardPostController {

    @PostMapping(
            value = "/onboardings",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CollectionResponse<OnboardResponseDto>> buildOnboard(@RequestBody OnboardRequestDto request) {



        return ResponseEntity.ok(new CollectionResponse<>(List.of(
                OnboardResponseDto.builder()
                        .onboardProtocolHash("123")
                        .processedAt("123").build()
        )));
    }
}
