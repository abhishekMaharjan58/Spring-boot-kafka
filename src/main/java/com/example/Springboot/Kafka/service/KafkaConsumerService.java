package com.example.Springboot.Kafka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final JavaMailSender javaMailSender;

    @KafkaListener(topics = "send_email_topic", groupId = "group_id")
    public void listen(String message) {
        sendEmail(message);
    }

    private void sendEmail(String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("test@gmail.com");
        mailMessage.setSubject("Kafka Email Notification");
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }
}
