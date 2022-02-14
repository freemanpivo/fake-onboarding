#!/bin/bash

if [ $SERICES == *"dynamodb" ]; then
    echo -e "\n#### Creating DynamoDB Table Schema..."
    for filename in /docker-entrypoint-initaws.d/schemas/dynamodb/*.json; do
        awslocal dynamodb create-table --cli-input-json file://${filename}
    done
    echo -e "#### End DynamoDB Table Schema flow.\n"

    echo -e "#### Insert data items at DynamoDB tables...\n"
    for filename in /docker-entrypoint-initaws.d/data/dynamodb/*.json; do
        awslocal dynamodb batch-write-item --request-items file://${filename} --return-consumed-capacity INDEXES --return-item-collection-metrics SIZE
    done
    echo -e "#### End data insertion at DynamoDB tables.\n"
fi