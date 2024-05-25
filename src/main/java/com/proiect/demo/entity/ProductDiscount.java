package com.proiect.demo.entity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="productdiscount")
public class ProductDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int product_id;
    private float discount;
    private LocalDateTime start_date;
    private LocalDateTime end_date;

    public ProductDiscount() {
    }

    public ProductDiscount(int id, int product_id, float discount, LocalDateTime start_date, LocalDateTime end_date) {
        this.id = id;
        this.product_id = product_id;
        this.discount = discount;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public LocalDateTime getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDateTime start_date) {
        this.start_date = start_date;
    }

    public LocalDateTime getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDateTime end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = start_date.format(formatter);
        String formattedDate1 = end_date.format(formatter);
        final StringBuilder sb = new StringBuilder("ProductDiscount{");
        sb.append("id=").append(id);
        sb.append(", product_id=").append(product_id);
        sb.append(", discount=").append(discount);
        sb.append(", start_date=").append(formattedDate);
        sb.append(", end_date=").append(formattedDate1);
        sb.append('}');
        return sb.toString();
    }
}
