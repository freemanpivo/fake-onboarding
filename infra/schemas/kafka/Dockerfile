FROM confluentinc/cp-kafka:4.1.2

USER root
WORKDIR usr/bin
COPY create-topic.sh create-topic.sh
RUN chmod +x create-topic.sh
ENTRYPOINT ["./create-topic.sh"]