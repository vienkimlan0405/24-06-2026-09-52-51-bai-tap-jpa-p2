package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // POST /products → thêm sản phẩm
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // GET /products → lấy tất cả sản phẩm
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // GET /products/{id} → lấy chi tiết sản phẩm
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // PUT /products/{id} → cập nhật
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product details) {
        Product product = getProductById(id);
        product.setName(details.getName());
        product.setPrice(details.getPrice());
        product.setDescription(details.getDescription());
        return productRepository.save(product);
    }

    // DELETE /products/{id} → xóa
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "Deleted successfully";
    }
}
