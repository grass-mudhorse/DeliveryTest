package com.sirius;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@MapperScan("com.sirius.repository")
@SpringBootApplication
public class ReviewApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReviewApplication.class,args);
    }
}
