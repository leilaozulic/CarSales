package com.example.CarSales.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "report")
public class Report {

    // Report
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private User user_id;
    @ManyToOne
    private Listing listing_id;

    private String reason;
    private String description;
    private String status;

    private java.sql.Timestamp created_at;

    public Report() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Listing getListing_id() {
        return listing_id;
    }

    public void setListing_id(Listing listing_id) {
        this.listing_id = listing_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
