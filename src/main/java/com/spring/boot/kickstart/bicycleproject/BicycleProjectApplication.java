package com.spring.boot.kickstart.bicycleproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class BicycleProjectApplication {

    public static void main(final String[] args) {
        SpringApplication.run(BicycleProjectApplication.class, args);
    }

}
