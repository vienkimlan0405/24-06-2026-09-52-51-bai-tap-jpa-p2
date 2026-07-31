package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book { //[cite: 2]
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //[cite: 2]

    private String title; //[cite: 2]
    private String author; //[cite: 2]
    private BigDecimal price; //[cite: 2]
}
