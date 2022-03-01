package com.service.customer.dynamodb.mapper;

import com.service.customer.domain.model.Customer;
import com.service.customer.dynamodb.entity.CustomerTable;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerTableModelMapper {
    @Mapping(source = "customerId", target = "id")
    @Mapping(source = "personalDocumentIdentifier", target = "personalDocumentIdentifierNumber")
    @Mapping(source = "name", target = "completeName")
    @Mapping(source = "email", target = "birthDate") // TODO: FIXME
    Customer toModel(CustomerTable item);
}
