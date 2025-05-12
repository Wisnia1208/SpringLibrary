package com.example.labSpringWTTO2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    private String title;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Category category; // Dodanie relacji do kategorii

    @ManyToOne
    private Publisher publisher; // Dodanie relacji do wydawcy
}