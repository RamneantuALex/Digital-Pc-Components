package com.proiect.demo.controller;

import com.proiect.demo.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.proiect.demo.entity.Basket;
import  com.proiect.demo.repository.BasketRepository;

import java.util.List;

@RestController
@RequestMapping("/basket")
public class BasketController {
    @Autowired
    private BasketRepository basketRepository;

    @GetMapping("/all")
    public List<Basket> getAllBaskets() {
        return basketRepository.findAll();
    }

    @GetMapping("/{id}")
    public Basket getBasketById(@PathVariable int id) {
        return basketRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Basket createBasket(@RequestBody Basket basket) {
        return basketRepository.save(basket);
    }

    @PutMapping("/{id}")
    public Basket updateBasket(@PathVariable int id, @RequestBody Basket basket) {
        Basket existingBasket = basketRepository.findById(id).orElse(null);
        if (existingBasket != null) {
            existingBasket.setClientId(basket.getClientId());
            existingBasket.setProductId(basket.getProductId());
            existingBasket.setQuantity(basket.getQuantity());
            return basketRepository.save(existingBasket);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteBasket(@PathVariable int id) {
        basketRepository.deleteById(id);
    }
}
