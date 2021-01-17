package com.github.muhammedshaheer.coursecatalogservice.entity;

/**
 * @author Muhammed Shaheer
 * @since 16 January 2021
 */

public class Course {

    private Integer courseId;
    private String courseName;
    private String author;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
