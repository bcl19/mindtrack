package com.bernardo.mindtrackapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bernardo.mindtrackapi.model.User;

public interface UserRepository extends JpaRepository<User, String> {
        User findByEmail(String email);

}
