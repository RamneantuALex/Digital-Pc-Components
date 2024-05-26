package com.proiect.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int clientId;
    private int productId;
    private int rating;
    private String comment;
    private LocalDateTime reviewDate;

    public Review() {
    }

    public Review(int id, int client_id, int product_id, int rating, String comment, LocalDateTime review_date) {
        this.id = id;
        this.clientId = client_id;
        this.productId = product_id;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = review_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int client_id) {
        this.clientId = client_id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int product_id) {
        this.productId = product_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDateTime review_date) {
        this.reviewDate = review_date;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Review{");
        sb.append("id=").append(id);
        sb.append(", client_id=").append(clientId);
        sb.append(", product_id=").append(productId);
        sb.append(", rating=").append(rating);
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", review_date=").append(reviewDate);
        sb.append('}');
        return sb.toString();
    }
}
