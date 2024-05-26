package com.proiect.demo.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
@Table (name="ServiceRequest")
public class ServiceRequest {
    private enum Status{
        SCHEDULED, IN_PROGRESS, COMPLETED, CANCELLED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int clientId;
    private LocalDateTime serviceDate;
    @Enumerated(EnumType.STRING)
    private Status status;

    public ServiceRequest() {
    }

    public ServiceRequest(int id, int client_id, LocalDateTime service_date, Status status) {
        this.id = id;
        this.clientId = client_id;
        this.serviceDate = service_date;
        this.status = status;
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

    public LocalDateTime getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDateTime service_date) {
        this.serviceDate = service_date;
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
        String formattedDate = serviceDate.format(formatter);
        final StringBuilder sb = new StringBuilder("ServiceRequest{");
        sb.append("id=").append(id);
        sb.append(", client_id=").append(clientId);
        sb.append(", service_date=").append(formattedDate);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
