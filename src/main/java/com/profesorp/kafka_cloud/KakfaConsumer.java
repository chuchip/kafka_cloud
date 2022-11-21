package com.profesorp.kafka_cloud;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("consumer")
public class KakfaConsumer {
    /*
    En el caso de tener dos listeners sobre el mismo topic, los mensajes se recibiran algunos en un listener y otros en otro.
    No es buena idea por lo tanto tener dos listeners iguales.

    @KafkaListener(topics={"hobbit"}, groupId="spring-boot-kafka")
    public void listenerHobbit(String topic)
    {
        System.out.println("Topic leido: "+topic);
    }
    */


    @KafkaListener(topics = "${message.topic.name1}", groupId = "spring-boot-kafka")
    public void consume(ConsumerRecord<Integer, String> record) {
        System.out.println("received = " + record.value() + " with key " + record.key());
    }
}
