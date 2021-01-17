package com.github.muhammedshaheer.coursecatalogservice.entity;

/**
 * @author Muhammed Shaheer
 * @since 17 January 2021
 */

public class User {

    private Integer userId;
    private Integer courseId;
    private String username;

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
