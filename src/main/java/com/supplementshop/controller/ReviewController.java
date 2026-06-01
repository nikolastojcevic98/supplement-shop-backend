package com.supplementshop.controller;

import com.supplementshop.model.Review;
import com.supplementshop.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping
    public List<Review> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        System.out.println("Dohvaćene recenzije: " + reviews.size());
        return reviews;
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        review.setReviewDate(java.time.LocalDateTime.now());
        return reviewRepository.save(review);
    }
}