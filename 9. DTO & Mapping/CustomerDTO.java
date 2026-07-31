package com.example.demo.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO { //[cite: 2]
    private Long id; //[cite: 2]
    private String name; //[cite: 2]
    private String phone; // Bỏ trường email để ẩn thông tin sensitive[cite: 2]
}
