# productprocessor

Java Microservice as Docker Container connecting to Kafka docker container.

# RUN kafka as docker container

   under root folder we have docker-compose where we have zookeeper and kafka props 
 <br /> $ docker-compose up  under root folder

# PACKAGE productprocessor as docker image and push to docker hub.

 $ mvn clean install
 <br /> $ docker push devopsvarun/productprocessor:0.0.1-SNAPSHOT

# RUN productprocessor as docker container.

 $ docker network ls    (check for gateway of kafka) -- kafka_default
 <br /> $ docker run -p 8080:8080 --network=kafka_default -e "SPRING_PROFILES_ACTIVE=dev" -e kafka_bootstrap_servers=kafka --link=kafka devopsvarun/productprocessor:0.0.1-SNAPSHOT
 
# WHEN running in local please enable:

<br />#- KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 and disable kafka:9092
