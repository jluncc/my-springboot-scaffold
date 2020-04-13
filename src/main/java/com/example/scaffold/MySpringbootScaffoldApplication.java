package com.example.scaffold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MySpringbootScaffoldApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringbootScaffoldApplication.class, args);
    }

}
