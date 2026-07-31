package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;

public interface StudentRepository extends JpaRepository<Student, Long> {}
public interface CourseRepository extends JpaRepository<Course, Long> {}
