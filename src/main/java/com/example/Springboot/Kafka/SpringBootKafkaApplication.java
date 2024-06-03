package com.example.Springboot.Kafka;

import com.example.Springboot.Kafka.service.KafkaProducerService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootKafkaApplication implements ApplicationRunner {

	private final KafkaProducerService kafkaProducer;

    public SpringBootKafkaApplication(KafkaProducerService kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		kafkaProducer.sendMessage("saurav message");
	}
}
