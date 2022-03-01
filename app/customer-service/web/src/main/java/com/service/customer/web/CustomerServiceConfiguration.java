package com.service.customer.web;

import com.service.customer.domain.port.CustomerDataStore;
import com.service.customer.domain.usecase.RetrieveCustomer;
import com.service.customer.domain.usecase.SearchSelector;
import com.service.customer.domain.usecase.strategy.CustomerSearchDocumentStrategy;
import com.service.customer.domain.usecase.strategy.CustomerSearchIdStrategy;
import com.service.customer.domain.usecase.strategy.factory.SearchFactory;
import com.service.customer.domain.util.SearchParamValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class CustomerServiceConfiguration {

    @Bean
    SearchFactory searchFactory(CustomerDataStore repository) {
        final var implementations = Set.of(
                new CustomerSearchDocumentStrategy(repository),
                new CustomerSearchIdStrategy(repository)
        );

        return new SearchFactory(implementations);
    }

    @Bean
    SearchParamValidator searchParamValidator() {
        return new SearchParamValidator();
    }

    @Bean
    SearchSelector searchSelector(SearchParamValidator validator,
                                  SearchFactory factory) {
        return new SearchSelector(
                validator,
                factory
        );
    }

    @Bean
    public RetrieveCustomer retrieveCustomer(SearchSelector selector) {
        return new RetrieveCustomer(selector);
    }

}
