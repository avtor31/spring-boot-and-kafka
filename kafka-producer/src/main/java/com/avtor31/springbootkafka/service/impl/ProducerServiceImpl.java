package com.avtor31.springbootkafka.service.impl;

import com.avtor31.springbootkafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${avtor31.kafka.topic}")
    private String kafkaTopic;

    public void send() {

        for(int i = 0; i < 100; i++){
            System.out.print(i);
            kafkaTemplate.send(kafkaTopic, Integer.toString(i), "message from producer - " + i );
        }

    }
}
