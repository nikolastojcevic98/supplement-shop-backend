package com.supplementshop.controller;

import com.supplementshop.model.Shipping;
import com.supplementshop.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipping")
public class ShippingController {

    @Autowired
    private ShippingRepository shippingRepository;

    @GetMapping
    public List<Shipping> getAllShipping() {
        return shippingRepository.findAll();
    }
}