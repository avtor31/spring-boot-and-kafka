package com.avtor31.springbootkafka.service.impl;

import com.avtor31.springbootkafka.service.ConsumerService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConsumerServiceImpl2 implements ConsumerService{

    @Value("${avtor31.kafka.topic}")
    private String kafkaTopic;

    @KafkaListener(topics = "${avtor31.kafka.topic}", groupId = "group2")
    @Transactional
    public void receive(ConsumerRecord<?, ?> record) throws Exception {
        System.out.println(String.format("Consumer 2. Topic - %s, Partition - %d, Value: %s, offset: %s", kafkaTopic, record.partition(), record.value(), record.offset()));
    }
}
