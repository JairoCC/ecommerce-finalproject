package com.keycode.notificationservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {
    @Autowired
    private JavaMailSender javaMailSender;

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @KafkaListener(topics = "notificationTopic")
    public void handleNotification(OrderPlacedEvent orderPlacedEvent){
        log.info("Notificaion recibida para la orden - {}", orderPlacedEvent.getOrderNumber());
        // enviar notificacion por email
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("fcuervoobando@gmail.com");
        email.setFrom("jctestingemails@gmail.com");
        email.setSubject("Orden Recibida");
        email.setText("Notificaion recibida para la orden " + orderPlacedEvent.getOrderNumber());

        javaMailSender.send(email);

    }

}