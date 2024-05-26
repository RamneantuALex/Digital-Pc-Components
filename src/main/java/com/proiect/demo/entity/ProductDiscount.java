package com.proiect.demo.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="ProductDiscount")
public class ProductDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int productId;
    private float discount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public ProductDiscount() {
    }

    public ProductDiscount(int id, int product_id, float discount, LocalDateTime start_date, LocalDateTime end_date) {
        this.id = id;
        this.productId = product_id;
        this.discount = discount;
        this.startDate = start_date;
        this.endDate = end_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int product_id) {
        this.productId = product_id;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime start_date) {
        this.startDate = start_date;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime end_date) {
        this.endDate = end_date;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = startDate.format(formatter);
        String formattedDate1 = endDate.format(formatter);
        final StringBuilder sb = new StringBuilder("ProductDiscount{");
        sb.append("id=").append(id);
        sb.append(", product_id=").append(productId);
        sb.append(", discount=").append(discount);
        sb.append(", start_date=").append(formattedDate);
        sb.append(", end_date=").append(formattedDate1);
        sb.append('}');
        return sb.toString();
    }
}
