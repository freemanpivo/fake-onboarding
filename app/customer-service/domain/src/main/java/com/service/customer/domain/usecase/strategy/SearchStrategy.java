package com.service.customer.domain.usecase.strategy;

import com.service.customer.domain.model.Customer;
import com.service.customer.domain.usecase.strategy.factory.SearchType;

public interface SearchStrategy {
    Customer find(String query);
    SearchType getType();
}
