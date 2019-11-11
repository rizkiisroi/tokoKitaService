package com.alam.tokokitaservice.web.rest;

import com.alam.tokokitaservice.service.TokoKitaServiceKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/toko-kita-service-kafka")
public class TokoKitaServiceKafkaResource {

    private final Logger log = LoggerFactory.getLogger(TokoKitaServiceKafkaResource.class);

    private TokoKitaServiceKafkaProducer kafkaProducer;

    public TokoKitaServiceKafkaResource(TokoKitaServiceKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
