package com.supplementshop.controller;

import com.supplementshop.model.SupplierOrderItem;
import com.supplementshop.repository.SupplierOrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier-order-items")
public class SupplierOrderItemController {

    @Autowired
    private SupplierOrderItemRepository supplierOrderItemRepository;

    @GetMapping
    public List<SupplierOrderItem> getAllSupplierOrderItems() {
        return supplierOrderItemRepository.findAll();
    }
}