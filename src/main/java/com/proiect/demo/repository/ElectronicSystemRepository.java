package com.proiect.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proiect.demo.entity.ElectronicSystem;

public interface ElectronicSystemRepository extends JpaRepository<ElectronicSystem, Integer>{
    List<ElectronicSystem> findByPrice(int price);

    List<ElectronicSystem> findByPromotion(boolean promotion);

    List<ElectronicSystem> findByStock(int stock);

}