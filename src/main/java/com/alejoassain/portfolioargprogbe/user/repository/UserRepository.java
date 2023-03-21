package com.alejoassain.portfolioargprogbe.user.repository;

import com.alejoassain.portfolioargprogbe.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
