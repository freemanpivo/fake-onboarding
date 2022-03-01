package com.service.customer.domain.port;

import com.service.customer.domain.model.Customer;

import java.util.Optional;

public interface CustomerDataStore {
    Optional<Customer> getById(String id);
    Optional<Customer> getByDocumentIdentifier(String documentIdentifier);
}
