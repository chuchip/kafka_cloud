package com.profesorp.kafka_cloud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.internals.Topic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Configuration
@Slf4j
@Profile("!consumer")
public class KafkaConfiguration {
    final AdminClient adminClient;//= AdminClient.create (Map.of(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"));

    @Value("${message.topic.name1}")
    String topic;

    final KafkaAdmin kafkaAdmin;

    public KafkaConfiguration( KafkaAdmin kafkaAdmin)
    {
        this.kafkaAdmin=kafkaAdmin;
        adminClient = AdminClient.create(kafkaAdmin.getConfigurationProperties());
    }
    @EventListener(ApplicationStartedEvent.class)
    public void showConfiguration() throws ExecutionException, InterruptedException {
            log.info("Configuracion topics adminClient....");

            StringBuilder sb=new StringBuilder();
            sb.append("Topicos existentes:\n ");

            ListTopicsOptions options = new ListTopicsOptions();
            options.listInternal(true);
            final List<String> topicList= new ArrayList<>();
            var topics= adminClient.listTopics().listings().get()
                    .stream()
                    .map(TopicListing::name)
                    .collect(Collectors.toList());

            DescribeTopicsResult result = adminClient.describeTopics(topics);
            result.topicNameValues().forEach((key, value) -> {
                try {
                    TopicDescription td= value.get();

                    sb.append("Topico: ")
                            .append(key)
                            .append(" No Partitions: ")
                            .append(td.partitions().size())
//                            .append(" Nº Replicas: ")
  //                          .append(adminClient.)
                            .append(" -> ")
                            .append(td)
                            .append("------------------------------------------------------------------")
                            .append("\n");


                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (ExecutionException e) {
                    log.error( "Failed to execute", e.getCause());
                }
            });
            log.info(sb.toString());
    }
    @Bean
    NewTopic createTopic()
    {
        log.info("Creado Topico: "+topic+" ....");
        var tb= TopicBuilder.name(topic).partitions(6).replicas(3)
                .build();

        return tb;
    }

//	@Bean
//    NewTopic hobbit2()
//	{
//		System.out.println("Creado bean hobbit2 ....");
//		var tb= TopicBuilder.name("hobbit2").partitions(6).replicas(3)
//			.build();
//		return tb;
//	}
}
