package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication(scanBasePackages = {"com.jk"})
@EnableEurekaClient
@RestController
@MapperScan("com.jk.mapper")
public class LoginProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginProviderApplication.class, args);
    }

}
