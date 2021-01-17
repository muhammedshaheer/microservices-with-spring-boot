package com.github.muhammedshaheer.userservice.repository;

import com.github.muhammedshaheer.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Muhammed Shaheer
 * @since 17 January 2021
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByUserId(Integer userId);

    List<User> findByCourseId(Integer courseId);
}
