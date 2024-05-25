package com.proiect.demo.repository;

import com.proiect.demo.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Integer> {

}
