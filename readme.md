## Publicar mensajes en kafka
- Lanzar aplicación con profile 'consumer'. (spring.profiles.active=consumer)


Ejecutar commando:
- curl -X POST http://localhost:8080/add?key=3 -d "Mensaje para topic1 ... 9:12A "  --header 'Content-Type: text/plain'

## Comandos útiles en consola:

> bin/kafka-console-consumer.sh --topic topicName1 --from-beginning --bootstrap-server localhost:9092

> bin/kafka-topics.sh --create --topic topicName1  --partitions 5 --replication-factor 3 --bootstrap-server localhost:9092

> bin/kafka-topics.sh --list --bootstrap-server localhost:9092

> bin/kafka-topics.sh --describe --topic topicName1 --bootstrap-server localhost:9092

> bin/kafka-topics.sh --delete --topic topicName1,topicName2,topicName3 --bootstrap-server localhost:9092

> bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group spring-boot-kafka