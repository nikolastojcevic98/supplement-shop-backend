package com.supplementshop.controller;

import com.supplementshop.model.CartItem;
import com.supplementshop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @GetMapping
    public List<CartItem> getAllCartItems() {
        return cartRepository.findAll();
    }
    @PostMapping
    public CartItem addToCart(@RequestBody CartItem cartItem) {
        cartItem.setAddedDate(java.time.LocalDateTime.now());
        return cartRepository.save(cartItem);
    }

    @DeleteMapping("/{id}")
    public void removeFromCart(@PathVariable Integer id) {
        cartRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public CartItem updateQuantity(@PathVariable Integer id, @RequestBody CartItem cartItem) {
        CartItem existing = cartRepository.findById(id).orElseThrow();
        existing.setQuantity(cartItem.getQuantity());
        return cartRepository.save(existing);
    }
}
