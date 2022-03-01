package com.service.customer.domain.port;

import com.service.customer.domain.model.Customer;

import java.util.Map;

public interface RetrieveCustomerCommand {
    Customer find(Map<String, String> searchParam);
}
