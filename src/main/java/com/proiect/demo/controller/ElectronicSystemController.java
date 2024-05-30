package com.proiect.demo.controller;


import com.proiect.demo.entity.*;
import com.proiect.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/electronicSystem")
public class ElectronicSystemController {
    @Autowired
    private ElectronicSystemRepository electronicSystemRepository;
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private ProductDiscountRepository discountRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping("/all")
    public List<ElectronicSystem> getAllBaskets() {
        return electronicSystemRepository.findAll();
    }
    @GetMapping("/promotion")
    public List<ElectronicSystem> getAllPromotions() {
        return electronicSystemRepository.findByPromotion(true);
    }

    @GetMapping("/{id}")
    public ElectronicSystem getElectronicSystemById(@PathVariable int id) {
        return electronicSystemRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ElectronicSystem createElectronicSystem(@RequestBody ElectronicSystem electronicSystem) {
        return electronicSystemRepository.save(electronicSystem);
    }

    @PutMapping("/{id}")
    public ElectronicSystem updateElectronicSystem(@PathVariable int id, @RequestBody ElectronicSystem electronicSystem) {
        ElectronicSystem existingElectronicSystem = electronicSystemRepository.findById(id).orElse(null);
        if (existingElectronicSystem != null) {
            existingElectronicSystem.setDescription(electronicSystem.getDescription());
            existingElectronicSystem.setPrice(electronicSystem.getPrice());
            existingElectronicSystem.setPromotion(electronicSystem.isPromotion());
            existingElectronicSystem.setReview(electronicSystem.getReview());
            existingElectronicSystem.setStock(electronicSystem.getStock());
            existingElectronicSystem.setSystemType(electronicSystem.getSystemType());
            return electronicSystemRepository.save(existingElectronicSystem);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteElectronicSystem(@PathVariable int id) {
        List<Basket> baskets = basketRepository.findAllByProductId(id);
        for (Basket basket : baskets) {
            basketRepository.deleteById(basket.getId());
        }

        List<ProductDiscount> discounts = discountRepository.findAllByProductId(id);
        for (ProductDiscount discount : discounts) {
            discountRepository.deleteById(discount.getId());
        }

        List<Review> reviews = reviewRepository.findAllByProductId(id);
        for(Review review: reviews){
            reviewRepository.deleteById(review.getId());
        }

        List<Orders> orders = ordersRepository.findAllByProductId(id);
        for(Orders order: orders){
            ordersRepository.deleteById(order.getId());
        }

        electronicSystemRepository.deleteById(id);
    }
}
