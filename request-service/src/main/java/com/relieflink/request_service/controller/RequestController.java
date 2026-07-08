package com.relieflink.request_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relieflink.request_service.model.Request;
import com.relieflink.request_service.service.RequestService;

@RestController
@RequestMapping("/api/requests") // Base URL for all endpoints in this controller
public class RequestController {

    @Autowired
    private RequestService requestService; // Injecting Service to handle business logic

    // Endpoint to create a new relief request
    // URL: POST http://localhost:8082/api/requests
    @PostMapping
    public ResponseEntity<Request> createRequest(@RequestBody Request request) {
        Request savedRequest = requestService.createRequest(request);
        return ResponseEntity.ok(savedRequest);
    }

    // Endpoint to get all relief requests
    // URL: GET http://localhost:8082/api/requests
    @GetMapping
    public ResponseEntity<List<Request>> getAllRequests() {
        List<Request> requests = requestService.getAllRequests();
        return ResponseEntity.ok(requests);
    }

    // Endpoint to get requests made by a specific user
    // URL: GET http://localhost:8082/api/requests/user/{userId}
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Request>> getRequestsByUserId(@PathVariable Long userId) {
        List<Request> userRequests = requestService.getRequestsByUserId(userId);
        return ResponseEntity.ok(userRequests);
    }
}