package com.proiect.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int client_id;
    private int product_id;
    private int rating;
    private String comment;
    private LocalDateTime review_date;

    public Review() {
    }

    public Review(int id, int client_id, int product_id, int rating, String comment, LocalDateTime review_date) {
        this.id = id;
        this.client_id = client_id;
        this.product_id = product_id;
        this.rating = rating;
        this.comment = comment;
        this.review_date = review_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
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

    public LocalDateTime getReview_date() {
        return review_date;
    }

    public void setReview_date(LocalDateTime review_date) {
        this.review_date = review_date;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Review{");
        sb.append("id=").append(id);
        sb.append(", client_id=").append(client_id);
        sb.append(", product_id=").append(product_id);
        sb.append(", rating=").append(rating);
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", review_date=").append(review_date);
        sb.append('}');
        return sb.toString();
    }
}
