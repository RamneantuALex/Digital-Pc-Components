package com.proiect.demo.repository;

import com.proiect.demo.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findAllByProductId(Integer id);
    List<Review> findAllById(Integer id);
}
