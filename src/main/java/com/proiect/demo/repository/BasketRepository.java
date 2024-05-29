package com.proiect.demo.repository;

import com.proiect.demo.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket, Integer> {
    List<Basket> findAllByProductId(Integer id);
}
