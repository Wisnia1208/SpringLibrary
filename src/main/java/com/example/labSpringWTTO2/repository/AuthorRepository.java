package com.example.labSpringWTTO2.repository;

import com.example.labSpringWTTO2.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}