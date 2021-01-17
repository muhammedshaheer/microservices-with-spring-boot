package com.github.muhammedshaheer.courseservice.controller;

import com.github.muhammedshaheer.courseservice.entity.Course;
import com.github.muhammedshaheer.courseservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Muhammed Shaheer
 * @since 16 January 2021
 */

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/")
    public String getCourseAppHome() {
        return "Course App Home";
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course getSpecificCourse(@PathVariable("id") int id) {
        return courseRepository.getOne(id);
    }

    @PostMapping("/courses")
    public void saveCourse(@RequestBody Course course) {
        courseRepository.save(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseRepository.deleteById(id);
    }
}
