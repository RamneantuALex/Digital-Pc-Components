package com.proiect.demo.controller;

import com.proiect.demo.entity.ServiceRequest;
import com.proiect.demo.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serviceRequest")
public class ServiceRequestController {
    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    @GetMapping("/all")
    public List<ServiceRequest> getAllServiceRequests() {
        return serviceRequestRepository.findAll();
    }

    @GetMapping("/{id}")
    public ServiceRequest getServiceRequestById(@PathVariable int id) {
        return serviceRequestRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ServiceRequest createServiceRequest(@RequestBody ServiceRequest serviceRequest) {
        return serviceRequestRepository.save(serviceRequest);
    }

    @PutMapping("/{id}")
    public ServiceRequest updateServiceRequest(@PathVariable int id, @RequestBody ServiceRequest serviceRequest) {
        ServiceRequest existingServiceRequest = serviceRequestRepository.findById(id).orElse(null);
        if (existingServiceRequest != null) {
            existingServiceRequest.setClientId(serviceRequest.getClientId());
            existingServiceRequest.setServiceDate(serviceRequest.getServiceDate());
            existingServiceRequest.setStatus(serviceRequest.getStatus());
            return serviceRequestRepository.save(existingServiceRequest);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteServiceRequest(@PathVariable int id) {
        serviceRequestRepository.deleteById(id);
    }

}
