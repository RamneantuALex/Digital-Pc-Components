package com.proiect.demo.repository;

import com.proiect.demo.entity.Basket;
import com.proiect.demo.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findAllByProductId(Integer id);
    List<Orders> findAllById(Integer id);
}
