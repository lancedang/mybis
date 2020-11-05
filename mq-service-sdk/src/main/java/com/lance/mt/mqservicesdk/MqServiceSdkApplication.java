package com.lance.mt.mqservicesdk;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@SpringBootApplication
public class MqServiceSdkApplication {
	public static void main(String[] args) {
		SpringApplication.run(MqServiceSdkApplication.class, args);
	}
}
