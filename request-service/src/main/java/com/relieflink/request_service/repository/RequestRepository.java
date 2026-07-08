package com.relieflink.request_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relieflink.request_service.model.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    
    // Custom query method to find requests by a specific user ID
    List<Request> findByUserId(Long userId);
}