package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ReceptionEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReceptionEurekaApplication.class, args);
    }

}
