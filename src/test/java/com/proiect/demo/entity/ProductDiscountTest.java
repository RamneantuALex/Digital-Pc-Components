package com.proiect.demo.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.*;

class ProductDiscountTest {

    private ProductDiscount productDiscount;

    @BeforeEach
    void setUp() {
        productDiscount = new ProductDiscount();
    }

    @Test
    void testId() {
        int id = 1;
        productDiscount.setId(id);
        assertEquals(id, productDiscount.getId());
    }

    @Test
    void testProductId() {
        int productId = 123;
        productDiscount.setProductId(productId);
        assertEquals(productId, productDiscount.getProductId());
    }

    @Test
    void testDiscount() {
        float discount = 10.5f;
        productDiscount.setDiscount(discount);
        assertEquals(discount, productDiscount.getDiscount());
    }

    @Test
    void testStartDate() {
        LocalDateTime startDate = LocalDateTime.now();
        productDiscount.setStartDate(startDate);
        assertEquals(startDate, productDiscount.getStartDate());
    }

    @Test
    void testEndDate() {
        LocalDateTime endDate = LocalDateTime.now().plusDays(7);
        productDiscount.setEndDate(endDate);
        assertEquals(endDate, productDiscount.getEndDate());
    }

    @Test
    void testToString() {
        int id = 1;
        int productId = 123;
        float discount = 10.5f;
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = LocalDateTime.now().plusDays(7);

        productDiscount.setId(id);
        productDiscount.setProductId(productId);
        productDiscount.setDiscount(discount);
        productDiscount.setStartDate(startDate);
        productDiscount.setEndDate(endDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedStartDate = startDate.format(formatter);
        String formattedEndDate = endDate.format(formatter);

        String expectedString = "ProductDiscount{" +
                "id=" + id +
                ", product_id=" + productId +
                ", discount=" + discount +
                ", start_date=" + formattedStartDate +
                ", end_date=" + formattedEndDate +
                '}';

        assertEquals(expectedString, productDiscount.toString());
    }
}
