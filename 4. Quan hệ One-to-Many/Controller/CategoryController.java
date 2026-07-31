package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    // POST /categories → tạo category
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    // POST /categories/{id}/products → thêm product vào category
    @PostMapping("/{id}/products")
    public Product addProductToCategory(@PathVariable Long id, @RequestBody Product product) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);
        return productRepository.save(product);
    }

    // GET /categories/{id}/products → lấy danh sách product theo category
    @GetMapping("/{id}/products")
    public List<Product> getProductsByCategory(@PathVariable Long id) {
        return productRepository.findByCategoryId(id);
    }
}
