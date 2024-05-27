package com.proiect.demo.controller;

import com.proiect.demo.entity.ServiceRequest;
import com.proiect.demo.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/serviceRequest")
public class ServiceRequestController {
    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    @GetMapping("/all")
    public String getAllServiceRequests(Model model) {
        List<ServiceRequest> serviceRequests = serviceRequestRepository.findAll();
        model.addAttribute("serviceRequests", serviceRequests);
        return "serviceRequest_list"; // Return the name of the HTML template
    }

    @GetMapping("/{id}")
    public String getServiceRequestById(@PathVariable int id, Model model) {
        ServiceRequest serviceRequest = serviceRequestRepository.findById(id).orElse(null);
        model.addAttribute("serviceRequest", serviceRequest);
        return "serviceRequest_detail"; // Return the name of the HTML template
    }

    @PostMapping
    @ResponseBody
    public ServiceRequest createServiceRequest(@RequestBody ServiceRequest serviceRequest) {
        return serviceRequestRepository.save(serviceRequest);
    }

    @PutMapping("/{id}")
    @ResponseBody
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
    @ResponseBody
    public void deleteServiceRequest(@PathVariable int id) {
        serviceRequestRepository.deleteById(id);
    }
}
