# productprocessor

# Java Microservice as Docker Container connecting to Kafka docker container.

# under root folder we have docker-compose where we have zookeeper and kafka props 
# RUN 
# $ docker-compose up  under root folder

# $ mvn clean install
# $ docker push devopsvarun/productprocessor:0.0.1-SNAPSHOT

# $ docker network ls    (check for gateway of kafka) -- kafka_default
# $ docker run -p 8080:8080 --network=kafka_default -e "SPRING_PROFILES_ACTIVE=dev" -e kafka_bootstrap_servers=kafka --link=kafka devopsvarun/productprocessor:0.0.1-SNAPSHOT
