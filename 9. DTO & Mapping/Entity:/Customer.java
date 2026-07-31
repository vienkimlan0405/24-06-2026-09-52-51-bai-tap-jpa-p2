package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer { //[cite: 2]
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //[cite: 2]

    private String name; //[cite: 2]
    private String email; //[cite: 2]
    private String phone; //[cite: 2]
}
