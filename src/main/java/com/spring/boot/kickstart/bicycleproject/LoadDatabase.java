package com.spring.boot.kickstart.bicycleproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;
import com.spring.boot.kickstart.bicycleproject.repository.BikeRepository;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(final BikeRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Bike("Rogue","fox",2450,"black")));
            log.info("Preloading " + repository.save(new Bike("Elite", "bmx",2500,"red")));

            log.info("Preloading " + repository.save(new Bike("Stolen", "bmx",3500,"blue")));
        };
    }
}
