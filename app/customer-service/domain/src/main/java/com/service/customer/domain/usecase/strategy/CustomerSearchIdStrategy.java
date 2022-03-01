package com.service.customer.domain.usecase.strategy;

import com.service.customer.domain.exception.NotFoundException;
import com.service.customer.domain.model.Customer;
import com.service.customer.domain.port.CustomerDataStore;
import com.service.customer.domain.usecase.strategy.factory.SearchType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class CustomerSearchIdStrategy implements SearchStrategy {
    private final CustomerDataStore repository;

    @Override
    public Customer find(String query) {
        log.info("searching customer by [id]...");
        final var customer = repository.getById(query);
        if (customer.isEmpty()) {
            log.warn("resource not found!");
            log.info("end: retrieve customer flow.");
            throw new NotFoundException();
        }

        return customer.get();
    }

    @Override
    public SearchType getType() {
        return SearchType.ID;
    }
}
