package com.proiect.demo.repository;

import com.proiect.demo.entity.ProductDiscount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDiscountRepository extends JpaRepository<ProductDiscount, Integer> {
}
