# Run kafka from docker
You can use this kafka kraft 

docker pull moeenz/docker-kafka-kraft

docker run 0.0.0.0:9093:9093 -e KRAFT_CONTAINER_HOST_NAME=kafka -e KRAFT_CREATE_TOPICS=topic-a,topic-b,topic-c -e KRAFT_PARTITIONS_PER_TOPIC=3 moeenz/docker-kafka-kraft

docker run --network=host -p 8080:8080 -e KAFKA_BROKERS=localhost:9093 docker.redpanda.com/vectorized/console:latest
