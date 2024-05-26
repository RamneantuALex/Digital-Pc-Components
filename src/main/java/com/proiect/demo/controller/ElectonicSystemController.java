package com.proiect.demo.controller;

import com.proiect.demo.entity.Basket;
import com.proiect.demo.entity.ElectronicSystem;
import com.proiect.demo.repository.ElectronicSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/electronicSystem")
public class ElectonicSystemController {
    @Autowired
    private ElectronicSystemRepository electronicSystemRepository;

    @GetMapping("/all")
    public List<ElectronicSystem> getAllBaskets() {
        return electronicSystemRepository.findAll();
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
        electronicSystemRepository.deleteById(id);
    }
}
