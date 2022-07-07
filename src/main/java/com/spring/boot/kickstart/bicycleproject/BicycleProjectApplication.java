package com.spring.boot.kickstart.bicycleproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BicycleProjectApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
        return builder.sources(BicycleProjectApplication.class);
    }

    public static void main(final String[] args) {
        SpringApplication.run(BicycleProjectApplication.class, args);
    }

}