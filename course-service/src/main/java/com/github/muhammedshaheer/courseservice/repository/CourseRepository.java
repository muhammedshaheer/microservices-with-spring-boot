package com.github.muhammedshaheer.courseservice.repository;

import com.github.muhammedshaheer.courseservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Muhammed Shaheer
 * @since 16 January 2021
 */

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
