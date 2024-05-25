package com.proiect.demo.repository;

import com.proiect.demo.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
