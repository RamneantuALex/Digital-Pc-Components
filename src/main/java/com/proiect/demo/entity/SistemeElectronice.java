package com.proiect.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "electronicsystem")
public class SistemeElectronice {

    private enum SystemType {
        DESKTOP_PC, LAPTOP_PC, PRINTER, PERIPHERAL, COMPONENT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int price;
    private String description;
    private boolean promotion;
    private int stock;
    private String review;

    @Enumerated(EnumType.STRING)
    private SystemType systemType;

    public SistemeElectronice() {}

    public SistemeElectronice(int price, String description, boolean promotion, int stock, String review, SystemType systemType) {
        this.price = price;
        this.description = description;
        this.promotion = promotion;
        this.stock = stock;
        this.review = review;
        this.systemType = systemType;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public SystemType getSystemType() {
        return systemType;
    }

    public void setSystemType(SystemType systemType) {
        this.systemType = systemType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SistemeElectronice{");
        sb.append("id=").append(id);
        sb.append(", price=").append(price);
        sb.append(", description='").append(description).append('\'');
        sb.append(", promotion=").append(promotion);
        sb.append(", stock=").append(stock);
        sb.append(", review='").append(review).append('\'');
        sb.append(", systemType=").append(systemType);
        sb.append('}');
        return sb.toString();
    }
}
