package com.example.labSpringWTTO2.repository;

import com.example.labSpringWTTO2.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}