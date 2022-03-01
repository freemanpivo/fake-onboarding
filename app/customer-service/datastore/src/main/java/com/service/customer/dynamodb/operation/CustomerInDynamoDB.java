package com.service.customer.dynamodb.repository;

import com.service.customer.domain.model.Customer;
import com.service.customer.domain.port.CustomerDataStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerInDynamoDB implements CustomerDataStore {

    @Override
    public Optional<Customer> getById(String id) {
        // TODO: remove 🤡 and implement DynamoDB connection
        if (id.equals("e1de96bf-cce5-45fd-9374-5661833ba612"))
            return Optional.of(mock());
        return Optional.empty();
    }

    @Override
    public Optional<Customer> getByDocumentIdentifier(String documentIdentifier) {
        // TODO: remove 🤡 and implement DynamoDB connection
        if (documentIdentifier.equals("11111111111"))
            return Optional.of(mock());
        return Optional.empty();
    }

    private Customer mock() {
        return Customer.builder()
                .id("e1de96bf-cce5-45fd-9374-5661833ba612")
                .completeName("Alambrado Amaral")
                .birthDate("1990-01-01")
                .personalDocumentIdentifierNumber("11111111111")
                .build();
    }
}
