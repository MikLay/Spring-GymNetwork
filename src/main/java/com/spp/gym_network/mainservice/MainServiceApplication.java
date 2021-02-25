package com.spp.gym_network.mainservice;

import com.spp.gym_network.mainservice.util.GymServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class MainServiceApplication {

    public static void main(final String[] args) {
        SpringApplication app = new SpringApplication(MainServiceApplication.class);
        app.setBanner(new Banner() {
            @Override
            public void printBanner(final Environment environment, final Class<?>
                    sourceClass, final PrintStream out) {
                out.print("\n\n\tGym Network!\n\n".toUpperCase());
            }
        });
        app.run(args);
    }

    final GymServiceProperties gymServiceProperties;

    @Autowired
    public MainServiceApplication(GymServiceProperties gymServiceProperties) {
        this.gymServiceProperties = gymServiceProperties;
    }
}
