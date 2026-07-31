package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee { //[cite: 2]
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //[cite: 2]

    private String name; //[cite: 2]
    private Double salary; //[cite: 2]
    private String department; //[cite: 2]
}
