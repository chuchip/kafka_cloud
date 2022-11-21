package com.profesorp.kafka_cloud;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewPartitions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.CompletableToListenableFutureAdapter;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@Profile("!consumer")
@Slf4j
public class ControllerProducer {

    final KafkaMessageProducer kafkaMessageProducer;


    @PostMapping(value="/add", consumes = MediaType.ALL_VALUE)
    public Mono<String> addTopicAndKey(@RequestParam(defaultValue = "1") Integer key,
                                       @RequestParam(defaultValue="${message.topic.name1}") String topic,
                                       @RequestBody  String body) throws InterruptedException
    {
        ListenableFuture<SendResult<Integer,String>> listenableFuture= kafkaMessageProducer.sendMessage(topic,key,body);
        Mono<String> mono =Mono.create( sink ->
        {
            listenableFuture.addCallback( (ok -> sink.success(ok.toString())),
                    (error -> sink.error(error)));
        });
        return mono;
    }

}
