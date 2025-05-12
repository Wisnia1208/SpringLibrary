package com.example.labSpringWTTO2.repository;

import com.example.labSpringWTTO2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
    List<Book> findByTitleContainingAndAuthorNameContaining(String title, String authorName);
}