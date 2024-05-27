package com.proiect.demo.controller;

import com.proiect.demo.entity.Orders;
import com.proiect.demo.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping("/all")
    public String getAllOrders(Model model) {
        List<Orders> orders = ordersRepository.findAll();
        model.addAttribute("orders", orders);
        return "orders_list"; // Return the name of the HTML template
    }

    @GetMapping("/{id}")
    public String getOrderById(@PathVariable int id, Model model) {
        Orders order = ordersRepository.findById(id).orElse(null);
        model.addAttribute("order", order);
        return "orders_detail"; // Return the name of the HTML template
    }

    @PostMapping
    @ResponseBody
    public Orders createOrder(@RequestBody Orders order) {
        return ordersRepository.save(order);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Orders updateOrder(@PathVariable int id, @RequestBody Orders order) {
        Orders existingOrder = ordersRepository.findById(id).orElse(null);
        if (existingOrder != null) {
            existingOrder.setClientId(order.getClientId());
            existingOrder.setProductId(order.getProductId());
            existingOrder.setQuantity(order.getQuantity());
            existingOrder.setOrderDate(order.getOrderDate());
            existingOrder.setStatus(order.getStatus());
            return ordersRepository.save(existingOrder);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteOrder(@PathVariable int id) {
        ordersRepository.deleteById(id);
    }
}
