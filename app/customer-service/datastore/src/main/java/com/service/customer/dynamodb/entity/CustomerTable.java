package com.service.customer.dynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import org.springframework.data.annotation.Id;

@DynamoDBTable(tableName = "customer_tb")
public class CustomerTable {
    @Id
    private CustomerTableId id;
    private String customerId;
    private String personalDocumentIdentifier;
    private String name;
    private String email;
    private String birthDate;

    public CustomerTable() {}

    public CustomerTable(CustomerTableId id, String customerId, String personalDocumentIdentifier, String name, String email, String birthDate) {
        this.id = id;
        this.customerId = customerId;
        this.personalDocumentIdentifier = personalDocumentIdentifier;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    @DynamoDBHashKey(attributeName = "partition_id_key")
    @DynamoDBIndexRangeKey(globalSecondaryIndexName = "customer_gsi")
    public String getPartitionKey() {
        return id != null ? id.getPartitionKey() : null;
    }

    public void setPartitionKey(String partitionKey) {
        if (id == null) {
            id = new CustomerTableId();
        }
        id.setPartitionKey(partitionKey);
    }

    @DynamoDBRangeKey(attributeName = "sort_key")
    @DynamoDBIndexHashKey(globalSecondaryIndexName = "customer_gsi")
    public String getSortKey() {
        return id != null ? id.getSortKey() : null;
    }

    public void setSortKey(String sortKey) {
        if (id == null) {
            id = new CustomerTableId();
        }
        id.setSortKey(sortKey);
    }

    @DynamoDBAttribute(attributeName = "customer_id")
    public String getCustomerId() {
        return customerId;
    }

    @DynamoDBAttribute(attributeName = "document_id")
    public String getPersonalDocumentIdentifier() {
        return personalDocumentIdentifier;
    }

    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return name;
    }

    @DynamoDBAttribute(attributeName = "email")
    public String getEmail() {
        return email;
    }

    @DynamoDBAttribute(attributeName = "birthdate")
    public String getBirthDate() {
        return birthDate;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setPersonalDocumentIdentifier(String personalDocumentIdentifier) {
        this.personalDocumentIdentifier = personalDocumentIdentifier;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
