package com.service.customer.dynamodb.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import lombok.extern.slf4j.Slf4j;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.service.customer.dynamodb.repository")
@Slf4j
public class DynamoDBConfiguration {
    private static final String ACCESS_ENV = "AWS_ACCESS_KEY";
    private static final String SECRET_ENV = "AWS_SECRET_KEY";
    private static final String ENDPOINT_ENV = "AWS_ENDPOINT";

    @Bean
    public AWSCredentials awsCredentials() {
        return new BasicAWSCredentials(getAccessKey(), getSecretKey());
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB client = new AmazonDynamoDBClient(awsCredentials());

        if (System.getenv(ENDPOINT_ENV) != null || !System.getenv(ENDPOINT_ENV).isBlank()) {
            log.info("working at localhost environment. configuring endpoint-url...");
            client.setEndpoint(System.getenv(ENDPOINT_ENV));
        }

        return client;
    }

    private String getAccessKey() {
        if (System.getenv(ACCESS_ENV) == null || System.getenv(ACCESS_ENV).isBlank()) {
            log.warn("missing AWS config env... [access]");
            return "FAKE";
        }
        return System.getenv(ACCESS_ENV);
    }

    private String getSecretKey() {
        if (System.getenv(SECRET_ENV) == null || System.getenv(SECRET_ENV).isBlank()) {
            log.warn("missing AWS config env... [secret]");
            return "NEWS";
        }
        return System.getenv(SECRET_ENV);
    }
}
