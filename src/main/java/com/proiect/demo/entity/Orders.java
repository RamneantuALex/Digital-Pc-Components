package com.proiect.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Entity
@Table(name = "Orders")
public class Orders {

    private enum Status {
        PENDING, SHIPPED, DELIVERED, CANCELLED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int clientId;
    private int productId;
    private int quantity;
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Orders() {
    }

    public Orders(int clientId, int productId, int quantity, LocalDateTime orderDate, Status status) {
        this.clientId = clientId;
        this.productId = productId;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.status = status;
    }
    public void changeStatus(String newStatus) {
        if (Arrays.stream(Status.values()).anyMatch(status -> status.name().equals(newStatus))) {
            this.status = Status.valueOf(newStatus);
        } else {
            throw new IllegalArgumentException("Invalid status: " + newStatus);
        }
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = orderDate.format(formatter);
        final StringBuilder sb = new StringBuilder("Orders{");
        sb.append("id=").append(id);
        sb.append(", clientId=").append(clientId);
        sb.append(", productId=").append(productId);
        sb.append(", quantity=").append(quantity);
        sb.append(", orderDate=").append(formattedDate);//Apare T dupa zile si de aceea am folosit DateFormatter
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
