package com.proiect.demo.repository;

import com.proiect.demo.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
