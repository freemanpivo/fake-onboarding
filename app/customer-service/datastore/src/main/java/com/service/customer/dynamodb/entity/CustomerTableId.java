package com.service.customer.dynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;

public class CustomerTableId {

    private String partitionKey;
    private String sortKey;

    public CustomerTableId() {}

    public CustomerTableId(String partitionKey, String sortKey) {
        this.partitionKey = partitionKey;
        this.sortKey = sortKey;
    }

    @DynamoDBHashKey(attributeName = "partition_id_key")
    public String getPartitionKey() {
        return partitionKey;
    }

    public void setPartitionKey(String partitionKey) {
        this.partitionKey = partitionKey;
    }

    @DynamoDBRangeKey(attributeName = "sort_key")
    public String getSortKey() {
        return sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }
}
