package com.example.CarSales.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.sql.Timestamp;

@Entity
public class Image {

    // Image
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Listing listing_id;
    private String url;
    private Integer order_index;
    private java.sql.Timestamp created_at;

    public Image() {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getOrder_index() {
        return order_index;
    }

    public void setOrder_index(Integer order_index) {
        this.order_index = order_index;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
