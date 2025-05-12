package com.example.labSpringWTTO2.repository;

import com.example.labSpringWTTO2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}