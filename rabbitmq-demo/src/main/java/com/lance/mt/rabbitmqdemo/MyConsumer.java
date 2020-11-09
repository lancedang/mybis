package com.lance.mt.rabbitmqdemo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer{

    @RabbitListener(queues = "someQueue")
    public void processMessage(String content) {
        // ...
    }


}