package com.service.customer.domain.usecase;

import com.service.customer.domain.exception.BadRequestException;
import com.service.customer.domain.exception.UnprocessableEntityException;
import com.service.customer.domain.usecase.strategy.SearchStrategy;
import com.service.customer.domain.usecase.strategy.factory.SearchFactory;
import com.service.customer.domain.usecase.strategy.factory.SearchType;
import com.service.customer.domain.util.SearchParamValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@RequiredArgsConstructor
@Slf4j
public class SearchSelector {
    private final SearchParamValidator validator;
    private final SearchFactory factory;

    public SearchStrategy strategy(Map<String, String> param) {
        if (!validator.hasValidKeySet(param.keySet())) {
            log.warn("invalid search keys...");
            log.info("end: retrieve customer flow.");
            throw new BadRequestException();
        }
        if (!validator.checkKeyValue(param)) {
            log.warn("invalid search values...");
            log.info("end: retrieve customer flow.");
            throw new UnprocessableEntityException();
        }

        final var searchType = SearchType.from(param.keySet().stream().findFirst().orElseThrow());

        return factory.of(searchType);
    }
}
