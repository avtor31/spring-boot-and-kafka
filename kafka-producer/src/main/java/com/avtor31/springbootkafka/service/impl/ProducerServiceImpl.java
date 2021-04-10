package com.avtor31.springbootkafka.service.impl;

import com.avtor31.springbootkafka.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {


  private final KafkaTemplate<String, String> kafkaTemplate;

  @Value("${avtor31.kafka.topic}")
  private String kafkaTopic;

  public void send() {
    for (int i = 0; i < 100; i++) {
      System.out.print(i);
      kafkaTemplate.send(kafkaTopic, Integer.toString(i) + " message from producer - " + i + "  Hello Kafka!!!)");
    }
  }
}
