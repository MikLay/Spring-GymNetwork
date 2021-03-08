package com.spp.gym_network.mainservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainServiceApplication {

    public static void main(final String[] args) {
        SpringApplication app = new SpringApplication(MainServiceApplication.class);
        app.setBanner((environment, sourceClass, out) -> out.print("\n\n\tGym Network!\n\n".toUpperCase()));
        app.run(args);
    }
}
