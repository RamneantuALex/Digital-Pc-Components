package com.proiect.demo.repository;

import com.proiect.demo.entity.Basket;
import com.proiect.demo.entity.ProductDiscount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDiscountRepository extends JpaRepository<ProductDiscount, Integer> {
    List<ProductDiscount> findAllByProductId(Integer id);

}
