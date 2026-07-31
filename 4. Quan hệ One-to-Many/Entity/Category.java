package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category { //[cite: 2]
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //[cite: 2]

    private String name; //[cite: 2]

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> products;
}
