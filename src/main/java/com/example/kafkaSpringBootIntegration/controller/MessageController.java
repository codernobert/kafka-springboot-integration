package com.example.kafkaSpringBootIntegration.controller;

import com.example.kafkaSpringBootIntegration.request.MessageRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class MessageController {

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/messages")
    public void publish(@RequestBody MessageRequest request) {
        kafkaTemplate.send("kafka_topic101", request.message());
    }

}
