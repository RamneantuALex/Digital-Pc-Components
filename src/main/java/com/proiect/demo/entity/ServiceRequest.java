package com.proiect.demo.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table (name="servicerequest")

public class ServiceRequest {

    private enum Status{
        SCHEDULED, IN_PROGRESS, COMPLETED, CANCELLED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int client_id;
    private LocalDateTime service_date;
    @Enumerated(EnumType.STRING)
    private Status status;

    public ServiceRequest() {
    }

    public ServiceRequest(int id, int client_id, LocalDateTime service_date, Status status) {
        this.id = id;
        this.client_id = client_id;
        this.service_date = service_date;
        this.status = status;
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

    public LocalDateTime getService_date() {
        return service_date;
    }

    public void setService_date(LocalDateTime service_date) {
        this.service_date = service_date;
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
        String formattedDate = service_date.format(formatter);
        final StringBuilder sb = new StringBuilder("ServiceRequest{");
        sb.append("id=").append(id);
        sb.append(", client_id=").append(client_id);
        sb.append(", service_date=").append(formattedDate);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
