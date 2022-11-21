package com.profesorp.kafka_cloud;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewPartitions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Profile("!consumer")
public class KafkaMessageProducer {
	private final KafkaTemplate<Integer, String> kafkaTemplate;


/*
    @EventListener(ApplicationStartedEvent.class)
	public void configBean()
	{
		//log.info("Admin Client: ");

//update the config entry name as per use case
		Map<String, NewPartitions> newPartitionSet = new HashMap<>();
		newPartitionSet.put(topic1, NewPartitions.increaseTo(6));
		//adminClient.createPartitions(newPartitionSet);

	}
*/
	
	public ListenableFuture<SendResult<Integer,String>> sendMessage(String topic,Integer key,String message) {

		return  kafkaTemplate.send(topic,key, message);
	}
}

