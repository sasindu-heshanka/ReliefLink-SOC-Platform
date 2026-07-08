package com.relieflink.request_service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique ID for each relief request (Primary Key)

    @Column(nullable = false)
    private Long userId; // ID of the user who created the request (comes from user-service)

    @Column(nullable = false)
    private String title; // Title of the request (e.g., "Need Dry Rations", "Medical Supply Request")

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description; // Detailed description of what is needed

    @Column(nullable = false)
    private String location; // Area or address where relief is needed

    @Column(nullable = false)
    private String status; // Current status of the request (PENDING, APPROVED, FULFILLED)

    private LocalDateTime createdAt; // Timestamp when the request was created

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now(); // Automatically sets current time before saving to database
        if (this.status == null) {
            this.status = "PENDING"; // Automatically sets initial status to PENDING if not provided
        }
    }
}