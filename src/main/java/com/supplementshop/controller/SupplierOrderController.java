package com.supplementshop.controller;

import com.supplementshop.model.SupplierOrder;
import com.supplementshop.repository.SupplierOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier-orders")
public class SupplierOrderController {

    @Autowired
    private SupplierOrderRepository supplierOrderRepository;

    @GetMapping
    @PreAuthorize("hasRole('EMPLOYEE') or hasRole('OWNER')")
    public List<SupplierOrder> getAllSupplierOrders() {
        return supplierOrderRepository.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('EMPLOYEE') or hasRole('OWNER')")
    public SupplierOrder createSupplierOrder(@RequestBody SupplierOrder order) {
        order.setOrderDate(java.time.LocalDateTime.now());
        return supplierOrderRepository.save(order);
    }
}