package com.service.customer.dynamodb.repository;

import com.service.customer.dynamodb.entity.CustomerTable;
import com.service.customer.dynamodb.entity.CustomerTableId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerTableRepository extends CrudRepository<CustomerTable, CustomerTableId> {
    List<CustomerTable> findBySortKey(String sortKey);
}
