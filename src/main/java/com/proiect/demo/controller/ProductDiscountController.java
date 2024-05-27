package com.proiect.demo.controller;

import com.proiect.demo.entity.ProductDiscount;
import com.proiect.demo.repository.ProductDiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productDiscounts")
public class ProductDiscountController {
    @Autowired
    private ProductDiscountRepository productDiscountRepository;

    @GetMapping("/all")
    public String getAllProductDiscounts(Model model) {
        List<ProductDiscount> productDiscounts = productDiscountRepository.findAll();
        model.addAttribute("productDiscounts", productDiscounts);
        return "productDiscount_list"; // Return the name of the HTML template
    }

    @GetMapping("/{id}")
    public String getProductDiscountById(@PathVariable int id, Model model) {
        ProductDiscount productDiscount = productDiscountRepository.findById(id).orElse(null);
        model.addAttribute("productDiscount", productDiscount);
        return "productDiscount_detail"; // Return the name of the HTML template
    }

    @PostMapping
    @ResponseBody
    public ProductDiscount createProductDiscount(@RequestBody ProductDiscount productDiscount) {
        return productDiscountRepository.save(productDiscount);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ProductDiscount updateProductDiscount(@PathVariable int id, @RequestBody ProductDiscount productDiscount) {
        ProductDiscount existingProductDiscount = productDiscountRepository.findById(id).orElse(null);
        if (existingProductDiscount != null) {
            existingProductDiscount.setProductId(productDiscount.getProductId());
            existingProductDiscount.setDiscount(productDiscount.getDiscount());
            existingProductDiscount.setStartDate(productDiscount.getStartDate());
            existingProductDiscount.setEndDate(productDiscount.getEndDate());
            return productDiscountRepository.save(existingProductDiscount);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteProductDiscount(@PathVariable int id) {
        productDiscountRepository.deleteById(id);
    }
}
