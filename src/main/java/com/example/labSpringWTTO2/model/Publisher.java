package com.example.labSpringWTTO2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Ręcznie dodany setter dla id
    public void setId(Long id) {
        this.id = id;
    }
}