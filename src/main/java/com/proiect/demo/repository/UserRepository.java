package com.proiect.demo.repository;

import com.proiect.demo.entity.Basket;
import com.proiect.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    List<User> findByRole(User.Role role);
    List<User> findByRoleNot(User.Role role);
    List<User> findAllById(Integer id);
}
