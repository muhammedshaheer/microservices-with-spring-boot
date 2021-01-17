package com.github.muhammedshaheer.coursecatalogservice.controller;

import com.github.muhammedshaheer.coursecatalogservice.entity.Course;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Muhammed Shaheer
 * @since 16 January 2021
 */

@RestController
public class CatalogController {

    private final EurekaClient client;
    private final CircuitBreakerFactory<?, ?> circuitBreakerFactory;

    public CatalogController(EurekaClient client, CircuitBreakerFactory<?, ?> circuitBreakerFactory) {
        this.client = client;
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    @GetMapping("/")
    public String getCatalogHome() {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("getCatalogHome");
        return circuitBreaker.run(() -> {
            InstanceInfo instanceInfo = client.getNextServerFromEureka("course-service", false);
            String courseAppURL = instanceInfo.getHomePageUrl();

            RestTemplate restTemplate = new RestTemplate();
            String courseAppMessage = restTemplate.getForObject(courseAppURL, String.class);
            return "Welcome to Course Catalog Service: " + courseAppMessage;
        }, throwable -> defaultHome());
    }

    @GetMapping("/catalog")
    public String getCatalog() {
        InstanceInfo instanceInfo = client.getNextServerFromEureka("course-service", false);
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppURL = courseAppURL + "/courses";

        RestTemplate restTemplate = new RestTemplate();
        String courses = restTemplate.getForObject(courseAppURL, String.class);
        return "Our courses are " + courses;
    }

    @GetMapping("/firstcourse")
    public String getSpecificCourse() {
        InstanceInfo instanceInfo = client.getNextServerFromEureka("course-service", false);
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppURL = courseAppURL + "/1";

        RestTemplate restTemplate = new RestTemplate();
        Course course = restTemplate.getForObject(courseAppURL, Course.class);

        instanceInfo = client.getNextServerFromEureka("user-service", false);
        String userAppURL = instanceInfo.getHomePageUrl();
        userAppURL = userAppURL + "/course/" + course.getCourseId();

        String user = restTemplate.getForObject(userAppURL, String.class);
        return "Our first course is " + course.getCourseName() + " and enrolled users are " + user;
    }

    private String defaultHome() {
        return "Welcome to Course Catalog Service: Please try after sometime...";
    }

}
