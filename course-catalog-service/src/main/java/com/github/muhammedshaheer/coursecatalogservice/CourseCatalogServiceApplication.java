package com.github.muhammedshaheer.coursecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Muhammed Shaheer
 * @since 16 January 2021
 */

@SpringBootApplication
@EnableEurekaClient
public class CourseCatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseCatalogServiceApplication.class, args);
    }

}
