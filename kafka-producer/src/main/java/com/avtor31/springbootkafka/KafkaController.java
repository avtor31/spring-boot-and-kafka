package com.avtor31.springbootkafka;

import com.avtor31.springbootkafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/send-to-kafka")
    public String sendMessage(){
        producerService.send();
        return "success";
    }
}
