package com.proiect.demo.controller;

import com.proiect.demo.entity.Basket;
import com.proiect.demo.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/baskets")
public class BasketController {
    @Autowired
    private BasketRepository basketRepository;

    @GetMapping("/all")
    public String getAllBaskets(Model model) {
        List<Basket> baskets = basketRepository.findAll();
        model.addAttribute("baskets", baskets);
        return "basket_list"; // Return the name of the HTML template
    }

    @GetMapping("/{id}")
    public String getBasketById(@PathVariable int id, Model model) {
        Basket basket = basketRepository.findById(id).orElse(null);
        model.addAttribute("basket", basket);
        return "basket_detail"; // Return the name of the HTML template
    }

    @PostMapping
    @ResponseBody
    public Basket createBasket(@RequestBody Basket basket) {
        return basketRepository.save(basket);
    }

    @PutMapping("/{id}")
    @ResponseBody
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
    @ResponseBody
    public void deleteBasket(@PathVariable int id) {
        basketRepository.deleteById(id);
    }
}
