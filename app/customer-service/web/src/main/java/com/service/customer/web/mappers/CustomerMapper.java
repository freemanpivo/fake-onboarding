package com.service.customer.web.mappers;

import com.service.customer.domain.model.Customer;
import com.service.customer.web.dto.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDto(Customer model);
}
