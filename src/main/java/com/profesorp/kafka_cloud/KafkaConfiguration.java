package com.profesorp.kafka_cloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

@Configuration
public class KafkaConfiguration {

   /* @Bean
    public ProducerFactory<String,String> producerFactory()
    {
        return new DefaultKafkaProducerFactory<>(
            Map.of(BOOTSTARAP_SERVER_CONFIG,"localhost:9092"
    }*/
}
