package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // GET /books/search?author=ABC[cite: 2]
    // GET /books/search?minPrice=100&maxPrice=300[cite: 2]
    @GetMapping("/search")
    public List<Book> searchBooks(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice) {

        if (author != null) {
            return bookRepository.findByAuthorContainingIgnoreCase(author);
        }
        if (minPrice != null && maxPrice != null) {
            return bookRepository.findByPriceBetween(minPrice, maxPrice);
        }
        return bookRepository.findAll();
    }
}
