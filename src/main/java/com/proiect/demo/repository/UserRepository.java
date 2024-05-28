package com.proiect.demo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proiect.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByEmail(String email);
}