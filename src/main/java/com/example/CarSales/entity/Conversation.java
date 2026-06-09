package com.example.CarSales.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "conversation")
public class Conversation {

    // Conversation
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Listing listing_id;

    @ManyToOne
    private User buyer_id;

    @ManyToOne
    private User seller_id;
    private java.sql.Timestamp created_at;

    public Conversation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Listing getListing_id() {
        return listing_id;
    }

    public void setListing_id(Listing listing_id) {
        this.listing_id = listing_id;
    }

    public User getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(User buyer_id) {
        this.buyer_id = buyer_id;
    }

    public User getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(User seller_id) {
        this.seller_id = seller_id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
