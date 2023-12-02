package com.siri_hate.phone_shop_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * The {@code PhoneShopApplication} class serves as the entry point for the Phone Shop Service application.
 * It uses Spring Boot to enable autoconfiguration and provides the necessary annotations for the application.
 * Additionally, it enables AspectJ AutoProxy for aspect-oriented programming support.
 *
 * <p>The main method within this class starts the Spring Boot application.
 *
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class PhoneShopApplication {

    /**
     * The main method to start the Phone Shop Service application.
     *
     * @param args Command line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(PhoneShopApplication.class, args);
    }

}
