package com.proiect.demo.controller;

import com.proiect.demo.entity.Review;
import com.proiect.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/all")
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable int id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable int id, @RequestBody Review review) {
        Review existingReview = reviewRepository.findById(id).orElse(null);
        if (existingReview != null) {
            existingReview.setClientId(review.getClientId());
            existingReview.setProductId(review.getProductId());
            existingReview.setRating(review.getRating());
            existingReview.setReviewDate(review.getReviewDate());
            existingReview.setComment(review.getComment());
            return reviewRepository.save(existingReview);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable int id) {
        reviewRepository.deleteById(id);
    }
}
