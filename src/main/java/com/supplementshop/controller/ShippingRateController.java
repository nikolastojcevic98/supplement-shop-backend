package com.supplementshop.controller;

import com.supplementshop.model.ShippingRate;
import com.supplementshop.repository.ShippingRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipping-rates")
public class ShippingRateController {

    @Autowired
    private ShippingRateRepository shippingRateRepository;

    @GetMapping
    public List<ShippingRate> getAllShippingRates() {
        return shippingRateRepository.findAll();
    }
}