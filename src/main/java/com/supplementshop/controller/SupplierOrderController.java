package com.supplementshop.controller;

import com.supplementshop.model.SupplierOrder;
import com.supplementshop.repository.SupplierOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier-orders")
public class SupplierOrderController {

    @Autowired
    private SupplierOrderRepository supplierOrderRepository;

    @GetMapping
    public List<SupplierOrder> getAllSupplierOrders() {
        return supplierOrderRepository.findAll();
    }
}
