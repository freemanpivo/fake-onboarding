#!/bin/bash

sleep 10.0s

kafkaTopicsArrayString="$KAFKA_TOPICS"
IFS=' ' read -r -a kafkaTopicsArray <<< "$kafkaTopicsArrayString"
zookeeperHostsValue=$ZOOKEEPER_HOSTS

echo "Zookeeper host: $zookeeperHostsValue"

# Create kafka topic for each item
for newTopic in "${kafkaTopicsArray[@]}"; do
  kafka-topics --create --zookeeper "$zookeeperHostsValue" --topic "$newTopic" --partitions 1 --replication-factor 1 --if-not-exists
done