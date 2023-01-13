package com.kohan.duna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kohan.duna.bootstrap.config")
public class DunaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DunaApplication.class, args);
    }

}
