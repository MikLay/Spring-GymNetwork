package com.spp.gym_network.mainservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class MainServiceApplication {

    public static void main(final String[] args) {
        SpringApplication app = new SpringApplication(MainServiceApplication.class);
        app.setBanner((environment, sourceClass, out) -> out.print("\n\n\tGym Network!\n\n".toUpperCase()));
        app.run(args);
    }

    @PostConstruct
    void started() {
        // set JVM timezone as UTC
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}
