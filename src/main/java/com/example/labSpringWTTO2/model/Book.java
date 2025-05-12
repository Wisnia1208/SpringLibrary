package com.example.labSpringWTTO2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JsonBackReference
    private Author author;

    // Ręcznie dodany setter dla id
    public void setId(Long id) {
        this.id = id;
    }
}