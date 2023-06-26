package com.example.studentservicedev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StudentServiceDevApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentServiceDevApplication.class, args);
    }

}
