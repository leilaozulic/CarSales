package com.example.CarSales.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Listing {

    // Listing
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Car car_id;

    @ManyToOne
    private User seller_id;

    @ManyToOne
    private Location location_id;

    private String title;
    private String description;

    @ManyToMany
    private List<User> applicationUsers;

    private java.math.BigDecimal current_price;
    private java.math.BigDecimal last_price;

    private Boolean is_active;

    private java.sql.Timestamp created_at;
    private java.sql.Timestamp updated_at;

    public Listing() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Car getCar_id() {
        return car_id;
    }

    public void setCar_id(Car car_id) {
        this.car_id = car_id;
    }

    public User getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(User seller_id) {
        this.seller_id = seller_id;
    }

    public Location getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Location location_id) {
        this.location_id = location_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(BigDecimal current_price) {
        this.current_price = current_price;
    }

    public BigDecimal getLast_price() {
        return last_price;
    }

    public void setLast_price(BigDecimal last_price) {
        this.last_price = last_price;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
