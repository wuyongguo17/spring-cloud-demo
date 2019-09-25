package com.wyg.readbusiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ReadBusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReadBusinessApplication.class,args);
    }
}
