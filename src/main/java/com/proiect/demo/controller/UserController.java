package com.proiect.demo.controller;

import com.proiect.demo.entity.*;
import com.proiect.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ServiceRequestRepository serviceRequestRepository;
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private OrdersRepository ordersRepository;
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/nonClient")
    public List<User> getNonClientUsers() {
        return userRepository.findByRoleNot(User.Role.CLIENT);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/signUp")
    public User createUser(@RequestBody User user) {
        // Ensure the role is set to CLIENT by default
        user.setRole(User.Role.CLIENT);
        return userRepository.save(user);
    }
    @PostMapping("/add")
    public User AddUser(@RequestBody User user) {

        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setRole(user.getRole());
            existingUser.setPassword(user.getPassword());
            return userRepository.save(existingUser);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        List<Basket> baskets = basketRepository.findAllByProductId(id);
        for (Basket basket : baskets) {
            basketRepository.deleteById(basket.getId());
        }
        List<Review> reviews = reviewRepository.findAllByProductId(id);
        for(Review review: reviews){
            reviewRepository.deleteById(review.getId());
        }

        List<Orders> orders = ordersRepository.findAllByProductId(id);
        for(Orders order: orders){
            ordersRepository.deleteById(order.getId());
        }
    List<ServiceRequest> serviceRequests=serviceRequestRepository.findAllById(id);
        for(ServiceRequest serviceRequest: serviceRequests){
            serviceRequestRepository.deleteById(serviceRequest.getId());
        }
        userRepository.deleteById(id);
    }

    @GetMapping("/login")
    public User loginUser(@RequestParam String email, @RequestParam String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent() && userOpt.get().getPassword().equals(password)) {
            return userOpt.get();
        } else {
            return null;
        }
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent() && userOpt.get().getPassword().equals(password)) {
            return userOpt.get();
        } else {
            return null;
        }
    }

    @GetMapping("/exists")
    public boolean emailExists(@RequestParam String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
