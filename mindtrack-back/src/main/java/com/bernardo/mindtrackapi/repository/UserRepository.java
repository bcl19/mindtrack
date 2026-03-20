package com.bernardo.mindtrackapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bernardo.mindtrackapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}