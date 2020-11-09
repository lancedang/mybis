package com.lance.mt.bisclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath*:/application-config-mq.xml", "classpath:/application-config-service.xml"})
public class BisClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BisClientApplication.class, args);
    }

}
