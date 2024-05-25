package com.proiect.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proiect.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    List<User> findByEmail(String email);
}