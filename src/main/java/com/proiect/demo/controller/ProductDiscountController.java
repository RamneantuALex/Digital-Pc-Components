package com.proiect.demo.controller;

import com.proiect.demo.entity.ProductDiscount;
import com.proiect.demo.repository.ProductDiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productDiscount")
public class ProductDiscountController {
    @Autowired
    private ProductDiscountRepository productDiscountRepository;

    @GetMapping("/all")
    public List<ProductDiscount> getAllProductDiscounts() {
        return productDiscountRepository.findAll();
    }

    @GetMapping("/{id}")
    public ProductDiscount getProductDiscountById(@PathVariable int id) {
        return productDiscountRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ProductDiscount createProductDiscount(@RequestBody ProductDiscount productDiscount) {
        return productDiscountRepository.save(productDiscount);
    }

    @PutMapping("/{id}")
    public ProductDiscount updateProductDiscount(@PathVariable int id, @RequestBody ProductDiscount productDiscount) {
        ProductDiscount existingProductDiscount = productDiscountRepository.findById(id).orElse(null);
        if (existingProductDiscount != null) {
            existingProductDiscount.setDiscount(productDiscount.getDiscount());
            existingProductDiscount.setEndDate(productDiscount.getEndDate());
            existingProductDiscount.setProductId(productDiscount.getProductId());
            existingProductDiscount.setStartDate(productDiscount.getStartDate());
            return productDiscountRepository.save(existingProductDiscount);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProductDiscount(@PathVariable int id) {
        productDiscountRepository.deleteById(id);
    }
}
