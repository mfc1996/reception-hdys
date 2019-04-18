package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication(scanBasePackages = {"com.jk"})
@EnableEurekaClient
@MapperScan("com.jk.mapper")
@RestController
public class ReceptionHomeProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReceptionHomeProviderApplication.class, args);
    }

}