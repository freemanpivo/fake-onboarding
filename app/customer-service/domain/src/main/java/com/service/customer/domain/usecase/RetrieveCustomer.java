package com.service.customer.domain.usecase;

import com.service.customer.domain.model.Customer;
import com.service.customer.domain.port.RetrieveCustomerCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@RequiredArgsConstructor
@Slf4j
public class RetrieveCustomer implements RetrieveCustomerCommand {
    private final SearchSelector selector;

    @Override
    public Customer find(Map<String, String> searchParam) {
        log.info("begin: retrieve customer flow...");
        final var strategy = selector.strategy(searchParam);
        final var query = searchParam.get(searchParam.keySet().stream().findFirst().orElseThrow());
        final var customer = strategy.find(query);
        log.info("end: retrieve customer flow.");

        return customer;
    }
}
