package com.github.muhammedshaheer.userservice.repository;

import com.github.muhammedshaheer.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Muhammed Shaheer
 * @since 17 January 2021
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
