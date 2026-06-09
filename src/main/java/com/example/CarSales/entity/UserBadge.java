package com.example.CarSales.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "user_badge")
public class UserBadge {

    // UserBadge
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private User user_id;
    private Integer badge_definition_id;

    private java.sql.Timestamp earned_at;

    public UserBadge() {
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBadge_definition_id() {
        return badge_definition_id;
    }

    public void setBadge_definition_id(Integer badge_definition_id) {
        this.badge_definition_id = badge_definition_id;
    }

    public Timestamp getEarned_at() {
        return earned_at;
    }

    public void setEarned_at(Timestamp earned_at) {
        this.earned_at = earned_at;
    }
}
