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

- KAFKA_ADVERTISED_HOST_NAME=localhost and disable kafka

# DEPLOY to GCP kubernetes

Create gcloud cluster at https://console.cloud.google.com/ - Kubernets Engine -> cluster-1
<br />$ gcloud container clusters get-credentials cluster-1 --zone us-central1-a --project #project-id#


In Local download kompose-windows-amd64 and run:
<br />$ kompose convert -> This will generate all the below files.


Deploy using generated files in GCP


$ kubectl apply -f zookeeper-deployment.yaml,zookeeper-service.yaml
<br />$ kubectl apply -f kafka-deployment.yaml,kafka-service.yaml
<br />$ kubectl apply -f productprocessor-deployment.yaml,productprocessor-service.yaml
