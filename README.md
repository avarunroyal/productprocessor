# productprocessor

Java Microservice as Docker Container connecting to Kafka docker container.

# RUN kafka as docker container

   under root folder we have docker-compose where we have zookeeper and kafka props 
 <br /> $ docker-compose up  under root folder <br />

# PACKAGE productprocessor as docker image and push to docker hub.

 $ mvn clean install
 <br /> $ docker push devopsvarun/productprocessor:0.0.1-SNAPSHOT <br />

# RUN productprocessor as docker container.

 $ docker network ls    (check for gateway of kafka) -- kafka_default
 <br /> $ docker run -p 8080:8080 --network=kafka_default -e "SPRING_PROFILES_ACTIVE=dev" -e kafka_bootstrap_servers=kafka --link=kafka devopsvarun/productprocessor:0.0.1-SNAPSHOT<br />
