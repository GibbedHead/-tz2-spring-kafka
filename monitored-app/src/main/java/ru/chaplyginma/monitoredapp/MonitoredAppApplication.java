package ru.chaplyginma.monitoredapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MonitoredAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitoredAppApplication.class, args);
    }

}
