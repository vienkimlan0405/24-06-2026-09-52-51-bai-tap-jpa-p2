package com.example.demo.repository;

import com.example.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // 1. Tìm order theo khoảng ngày[cite: 2]
    List<Order> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

    // 2. Tìm top 5 order có totalAmount lớn nhất[cite: 2]
    @Query("SELECT o FROM Order o ORDER BY o.totalAmount DESC LIMIT 5")
    List<Order> findTop5ByOrderByTotalAmountDesc();
}
