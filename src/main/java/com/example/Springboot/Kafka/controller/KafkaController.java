package com.example.Springboot.Kafka.controller;

import com.example.Springboot.Kafka.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mail")
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;

    @GetMapping("/send-email")
    public String sendEmail(@RequestParam String message) {
        kafkaProducerService.sendMessage(message);
        return "Email sent successfully";
    }
}
