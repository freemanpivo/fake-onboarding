package com.service.onboard.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.service.onboard"})
public class OnboardingApplication {

    public static void main(String[] args) {

        SpringApplication.run(OnboardingApplication.class);
    }
}
