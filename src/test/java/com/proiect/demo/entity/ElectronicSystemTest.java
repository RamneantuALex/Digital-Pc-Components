package com.proiect.demo.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElectronicSystemTest {
    private ElectronicSystem electronicSystem;

    @BeforeEach
    void setup(){
        electronicSystem = new ElectronicSystem();
    }

    @Test
    void testId(){
        int id = 1;
        electronicSystem.setId(id);
        System.out.println(electronicSystem.getId());
        assertEquals(id, electronicSystem.getId());
    }

    @Test
    void testDescription(){
        String description = "Test";
        electronicSystem.setDescription(description);
        System.out.println(electronicSystem.getDescription());
        assertEquals(description, electronicSystem.getDescription());
    }

    @Test
    void testPrice(){
        int price = 100;
        electronicSystem.setPrice(price);
        System.out.println(electronicSystem.getPrice());
        assertEquals(price, electronicSystem.getPrice());
    }

    @Test
    void testPromotion(){
        boolean promotion = true;
        electronicSystem.setPromotion(promotion);
        System.out.println(electronicSystem.isPromotion());
        assertEquals(promotion, electronicSystem.isPromotion());
    }

    @Test
    void testReview(){
        String review = "Good";
        electronicSystem.setReview(review);
        System.out.println(electronicSystem.getReview());
        assertEquals(review, electronicSystem.getReview());
    }
}
