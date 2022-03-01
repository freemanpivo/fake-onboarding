package com.service.customer.domain.usecase.strategy.factory;

import com.service.customer.domain.usecase.strategy.SearchStrategy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SearchFactory {
    private final Map<SearchType, SearchStrategy> strategies;

    public SearchFactory(Set<SearchStrategy> implementations) {
        final var tempStrategies = new HashMap<SearchType, SearchStrategy>();
        implementations.forEach(
                implementation -> tempStrategies.put(implementation.getType(), implementation)
        );
        this.strategies = Collections.unmodifiableMap(tempStrategies);
    }

    public SearchStrategy of(SearchType type) {
        return strategies.get(type);
    }
}
