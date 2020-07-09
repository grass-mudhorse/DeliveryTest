package com.sirius;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestFeignApplication.class,args);
    }
}
