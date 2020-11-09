package com.lance.mt.bisserviceimpl;

import com.lance.mt.bisservicefacade.pboc.PbocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ImportResource(locations = {"classpath*:/application-service-mq.xml"})
public class BisServiceImplApplication {


    public static void main(String[] args) {
        SpringApplication.run(BisServiceImplApplication.class, args);
    }

}
