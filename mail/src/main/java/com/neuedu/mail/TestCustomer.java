package com.neuedu.mail;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TestCustomer {
    @RabbitListener(queues = "testqueue")
    public void receiver(Message message) {
        System.out.println(new String(message.getBody()));
    }
}
