package com.service.customer.web.api;

import com.service.customer.domain.port.RetrieveCustomerCommand;
import com.service.customer.web.dto.CollectionResponse;
import com.service.customer.web.dto.CustomerDto;
import com.service.customer.web.mappers.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CustomerGetController {
    private final RetrieveCustomerCommand usecase;
    private final CustomerMapper mapper;

    @GetMapping(
            value = "/customers",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CollectionResponse<CustomerDto>> getCustomer(@RequestParam Map<String, String> queryParams) {
        final var model = usecase.find(queryParams);
        final var dto = mapper.toDto(model);
        final var response = new CollectionResponse<>(List.of(dto));

        return ResponseEntity.ok(response);
    }

}
