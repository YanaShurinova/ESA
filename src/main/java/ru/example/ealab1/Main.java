package ru.example.ealab1;

import org.springframework.boot.SpringApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableJms
@SpringBootApplication(scanBasePackages = "ru.example.ealab1")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
