package com.service.customer.dynamodb.operation;

import com.amazonaws.SdkClientException;
import com.service.customer.domain.exception.ServiceUnavailableException;
import com.service.customer.domain.model.Customer;
import com.service.customer.domain.port.CustomerDataStore;
import com.service.customer.dynamodb.entity.CustomerTableId;
import com.service.customer.dynamodb.mapper.CustomerTableModelMapper;
import com.service.customer.dynamodb.repository.CustomerTableRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.ConnectException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomerInDynamoDB implements CustomerDataStore {
    private static final String ID_PREFIX = "CUSTOMER#";
    private static final String DOCUMENT_PREFIX = "DOCUMENT_ID#";

    private final CustomerTableRepository repository;
    private final CustomerTableModelMapper mapper;


    @Override
    public Optional<Customer> getById(String id) {
        try {
            final var pk = ID_PREFIX.concat(id);
            final var query = repository.findById(new CustomerTableId(pk, pk));

            if (query.isEmpty()) {
                return Optional.empty();
            }

            return Optional.of(mapper.toModel(query.get()));
        } catch (SdkClientException exception) {
            log.error("can't reach [DynamoDB]! check service status.");
            throw new ServiceUnavailableException();
        }
    }

    @Override
    public Optional<Customer> getByDocumentIdentifier(String documentIdentifier) {
        final var sk = DOCUMENT_PREFIX.concat(documentIdentifier);

        try {
            final var query = repository.findBySortKey(sk);

            if (query == null || query.isEmpty()) {
                return Optional.empty();
            }

            return Optional.of(mapper.toModel(query.get(0)));
        } catch (SdkClientException exception) {
            log.error("can't reach [DynamoDB]! check service status.");
            throw new ServiceUnavailableException();
        }

    }
}
