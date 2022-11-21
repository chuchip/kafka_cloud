package com.profesorp.kafka_cloud;

import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.config.ConfigResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaAdmin;

import javax.annotation.PostConstruct;
import java.util.*;

@SpringBootApplication
public class KafkaCloudApplication {



	public static void main(String[] args) {
		SpringApplication.run(KafkaCloudApplication.class, args);

	}

/*	@Bean
	AdminClient getAdminClient() {
		AdminClient adminClient = AdminClient.create(Map.of(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER));
		return adminClient;
	}*/



}
