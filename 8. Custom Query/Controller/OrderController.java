package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    // API GET /orders/top → trả về top 5 order
    @GetMapping("/top")
    public List<Order> getTop5Orders() {
        return orderRepository.findTop5ByOrderByTotalAmountDesc();
    }

    // API phụ: Tìm theo khoảng ngày
    @GetMapping("/range")
    public List<Order> getOrdersByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return orderRepository.findByCreatedAtBetween(start, end);
    }
}
