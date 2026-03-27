package com.bernardo.mindtrackapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bernardo.mindtrackapi.model.Result;

public interface ResultRepository extends JpaRepository<Result, Long> {
}