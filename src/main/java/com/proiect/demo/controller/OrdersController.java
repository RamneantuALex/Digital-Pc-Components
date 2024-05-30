package com.proiect.demo.controller;

import com.proiect.demo.entity.Orders;
import com.proiect.demo.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.String.valueOf;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping("/all")
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @GetMapping("/{id}")
    public Orders getOrdersById(@PathVariable int id) {
        return ordersRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Orders createOrders(@RequestBody Orders orders) {
        return ordersRepository.save(orders);
    }
    @PutMapping("/change/{id}")
    public Orders changeStatus(@PathVariable int id, @RequestBody String newStatus) {
        Orders existingOrder = ordersRepository.findById(id).orElse(null);
        if (existingOrder != null) {
           existingOrder.changeStatus(newStatus); // Actualizare status
            return ordersRepository.save(existingOrder);
        }
        return null;
    }


    @PutMapping("/{id}")
    public Orders updateOrders(@PathVariable int id, @RequestBody Orders orders) {
        Orders existingOrders = ordersRepository.findById(id).orElse(null);
        if (existingOrders != null) {
            existingOrders.setClientId(orders.getClientId());
            existingOrders.setProductId(orders.getProductId());
            existingOrders.setQuantity(orders.getQuantity());
            existingOrders.setOrderDate(orders.getOrderDate());
            existingOrders.setStatus(orders.getStatus());
            return ordersRepository.save(existingOrders);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteOrders(@PathVariable int id) {
        ordersRepository.deleteById(id);
    }
}
