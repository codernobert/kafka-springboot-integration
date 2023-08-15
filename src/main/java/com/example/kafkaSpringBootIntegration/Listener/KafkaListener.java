package com.example.kafkaSpringBootIntegration.Listener;

import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

   @org.springframework.kafka.annotation.KafkaListener(
           topics = "kafka_topic101",
           groupId = "kafkaGroupId")
    void listener(String data) {
       System.out.println("Listener received: " + data + " 💕");
    }

}
