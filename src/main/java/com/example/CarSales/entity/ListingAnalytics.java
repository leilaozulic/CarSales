package com.example.CarSales.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.sql.Timestamp;

@Entity
public class ListingAnalytics {

    // ListingAnalytics
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Listing listing_id;
    private Integer view_count;
    private Integer save_count;
    private java.sql.Timestamp updated_at;

    public ListingAnalytics() {
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

    public Integer getView_count() {
        return view_count;
    }

    public void setView_count(Integer view_count) {
        this.view_count = view_count;
    }

    public Integer getSave_count() {
        return save_count;
    }

    public void setSave_count(Integer save_count) {
        this.save_count = save_count;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
