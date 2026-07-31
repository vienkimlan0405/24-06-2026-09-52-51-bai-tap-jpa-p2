package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User { //[cite: 2]
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //[cite: 2]

    @NotBlank(message = "Username không được để trống") //[cite: 2]
    private String username; //[cite: 2]

    @Email(message = "Email không hợp lệ") //[cite: 2]
    @NotBlank(message = "Email không được để trống")
    private String email; //[cite: 2]

    @Size(min = 6, message = "Mật khẩu phải chứa ít nhất 6 ký tự") //[cite: 2]
    private String password; //[cite: 2]
}
