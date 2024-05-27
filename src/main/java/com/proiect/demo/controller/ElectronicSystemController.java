package com.proiect.demo.controller;

import com.proiect.demo.entity.ElectronicSystem;
import com.proiect.demo.repository.ElectronicSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/electronicSystems")
public class ElectronicSystemController {
    @Autowired
    private ElectronicSystemRepository electronicSystemRepository;

    @GetMapping("/all")
    public String getAllElectronicSystems(Model model) {
        List<ElectronicSystem> electronicSystems = electronicSystemRepository.findAll();
        model.addAttribute("electronicSystems", electronicSystems);
        return "electronicSystem_list"; // Return the name of the HTML template
    }

    @GetMapping("/{id}")
    public String getElectronicSystemById(@PathVariable int id, Model model) {
        ElectronicSystem electronicSystem = electronicSystemRepository.findById(id).orElse(null);
        model.addAttribute("electronicSystem", electronicSystem);
        return "electronicSystem_detail"; // Return the name of the HTML template
    }

    @PostMapping
    @ResponseBody
    public ElectronicSystem createElectronicSystem(@RequestBody ElectronicSystem electronicSystem) {
        return electronicSystemRepository.save(electronicSystem);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ElectronicSystem updateElectronicSystem(@PathVariable int id, @RequestBody ElectronicSystem electronicSystem) {
        ElectronicSystem existingElectronicSystem = electronicSystemRepository.findById(id).orElse(null);
        if (existingElectronicSystem != null) {
            existingElectronicSystem.setPrice(electronicSystem.getPrice());
            existingElectronicSystem.setDescription(electronicSystem.getDescription());
            existingElectronicSystem.setPromotion(electronicSystem.isPromotion());
            existingElectronicSystem.setStock(electronicSystem.getStock());
            existingElectronicSystem.setReview(electronicSystem.getReview());
            existingElectronicSystem.setSystemType(electronicSystem.getSystemType());
            return electronicSystemRepository.save(existingElectronicSystem);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteElectronicSystem(@PathVariable int id) {
        electronicSystemRepository.deleteById(id);
    }
}
