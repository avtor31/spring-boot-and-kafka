package com.avtor31.springbootkafka;

import com.avtor31.springbootkafka.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final ProducerService producerService;

    @GetMapping("/send-to-kafka")
    public ResponseEntity<Void> sendMessage(){
        producerService.send();
        return ResponseEntity.ok().build();
    }
}
