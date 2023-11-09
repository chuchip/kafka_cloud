## Publicar mensajes en kafka
- Lanzar aplicación con profile 'consumer'. (spring.profiles.active=consumer)


Ejecutar commando:
- curl -X POST http://localhost:8080/add?key=3 -d "Mensaje para topic1 ... 9:12A "  --header 'Content-Type: text/plain'

##  Acceder a consola de kafka
Lanzar el docker-compose que lanzara 3 instancias de  kafka, ademas del zookeeper: 

> docker-compose up -d

Desde windows podremos acceder a las instancias en el puerto 9093,9094 y 9095 de localhost.

#### Comandos utiles.

Entrar al primer servidor de docker, el cual se llamara `kafka_cloud-kafka2_docker-1` (puedes controlarlo ejecutando el comando "docker ps" ).

> docker exec -it "kafka_cloud-kafka2_docker-1" bash

Una vez dentro del servidor, cambiar al directorio "/opt/bitnami/kafka" que es donde se instala Kafka.

##### Consumir  a topic
> bin/kafka-console-consumer.sh --topic topicName1 --from-beginning --bootstrap-server localhost:9092

##### Create a topic
> bin/kafka-topics.sh --create --topic topicName1  --partitions 5 --replication-factor 3 --bootstrap-server localhost:9092

##### List  availaible topics 
> bin/kafka-topics.sh --list --bootstrap-server localhost:9092

> bin/kafka-topics.sh --describe --topic topicName1 --bootstrap-server localhost:9092

> bin/kafka-topics.sh --delete --topic topicName1,topicName2,topicName3 --bootstrap-server localhost:9092

> bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group spring-boot-kafka
