package com.relieflink.request_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relieflink.request_service.model.Request;
import com.relieflink.request_service.repository.RequestRepository;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository; // Injecting Repository to talk with the Database

    // Method to create a new relief request
    public Request createRequest(Request request) {
        return requestRepository.save(request); // Saves the request object to MySQL
    }

    // Method to get all relief requests available in the system
    public List<Request> getAllRequests() {
        return requestRepository.findAll(); // Fetches all rows from requests table
    }

    // Method to get requests created by a specific user
    public List<Request> getRequestsByUserId(Long userId) {
        return requestRepository.findByUserId(userId); // Uses the custom query we created in Repository
    }
}