package com.github.muhammedshaheer.coursecatalogservice.controller;

import com.github.muhammedshaheer.coursecatalogservice.entity.Course;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
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

    public CatalogController(EurekaClient client) {
        this.client = client;
    }

    @GetMapping("/")
    public String getCatalogHome() {
        InstanceInfo instanceInfo = client.getNextServerFromEureka("course-service", false);
        String courseAppURL = instanceInfo.getHomePageUrl();

        RestTemplate restTemplate = new RestTemplate();
        String courseAppMessage = restTemplate.getForObject(courseAppURL, String.class);
        return ("Welcome to Course Catalog Service: " + courseAppMessage);
    }

    @GetMapping("/catalog")
    public String getCatalog() {
        InstanceInfo instanceInfo = client.getNextServerFromEureka("course-service", false);
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppURL = courseAppURL + "/courses";

        RestTemplate restTemplate = new RestTemplate();
        String courses = restTemplate.getForObject(courseAppURL, String.class);
        return ("Our courses are " + courses);
    }

    @GetMapping("/firstcourse")
    public String getSpecificCourse() {
        InstanceInfo instanceInfo = client.getNextServerFromEureka("course-service", false);
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppURL = courseAppURL + "/1";

        RestTemplate restTemplate = new RestTemplate();
        Course course = restTemplate.getForObject(courseAppURL, Course.class);
        return ("Our first course is " + course.getCourseName());
    }

}
