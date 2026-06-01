package com.supplementshop.controller;

import com.supplementshop.model.Order;
import com.supplementshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        order.setOrderDate(java.time.LocalDateTime.now());
        return orderRepository.save(order);
    }

    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('EMPLOYEE') or hasRole('OWNER')")
    public Order updateOrderStatus(@PathVariable Integer id, @RequestBody Order orderUpdate) {
        Order existingOrder = orderRepository.findById(id).orElseThrow();
        existingOrder.setStatus(orderUpdate.getStatus());
        return orderRepository.save(existingOrder);
    }
}