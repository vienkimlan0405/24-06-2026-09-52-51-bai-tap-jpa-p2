package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Lọc theo author[cite: 2]
    List<Book> findByAuthorContainingIgnoreCase(String author);

    // Lọc theo khoảng giá[cite: 2]
    List<Book> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
