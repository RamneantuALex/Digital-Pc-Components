package com.proiect.demo.repository;

import com.proiect.demo.entity.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Integer> {
}
