package com.github.muhammedshaheer.userservice.controller;

import com.github.muhammedshaheer.userservice.entity.User;
import com.github.muhammedshaheer.userservice.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Muhammed Shaheer
 * @since 17 January 2021
 */

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public List<User> getUserByUserId(@PathVariable("userId") Integer userId) {
        return userRepository.findByUserId(userId);
    }

    @GetMapping("/course/{courseId}")
    public List<User> getUserByCourseId(@PathVariable("courseId") Integer courseId) {
        return userRepository.findByCourseId(courseId);
    }
}
