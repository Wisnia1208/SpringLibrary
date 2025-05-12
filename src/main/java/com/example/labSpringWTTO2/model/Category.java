package com.example.labSpringWTTO2.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Ręcznie dodany setter dla id
    public void setId(Long id) {
        this.id = id;
    }
}