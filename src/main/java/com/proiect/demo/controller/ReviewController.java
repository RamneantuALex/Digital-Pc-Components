package com.proiect.demo.controller;

import com.proiect.demo.entity.Review;
import com.proiect.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/all")
    public String getAllReviews(Model model) {
        List<Review> reviews = reviewRepository.findAll();
        model.addAttribute("reviews", reviews);
        return "review_list"; // Return the name of the HTML template
    }

    @GetMapping("/{id}")
    public String getReviewById(@PathVariable int id, Model model) {
        Review review = reviewRepository.findById(id).orElse(null);
        model.addAttribute("review", review);
        return "review_detail"; // Return the name of the HTML template
    }

    @PostMapping
    @ResponseBody
    public Review createReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Review updateReview(@PathVariable int id, @RequestBody Review review) {
        Review existingReview = reviewRepository.findById(id).orElse(null);
        if (existingReview != null) {
            existingReview.setClientId(review.getClientId());
            existingReview.setProductId(review.getProductId());
            existingReview.setRating(review.getRating());
            existingReview.setComment(review.getComment());
            existingReview.setReviewDate(review.getReviewDate());
            return reviewRepository.save(existingReview);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteReview(@PathVariable int id) {
        reviewRepository.deleteById(id);
    }
}
