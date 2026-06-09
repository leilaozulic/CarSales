package com.example.CarSales.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "rating")
public class Rating {

    // Rating
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private User rater_id;
    @ManyToOne
    private User rated_user_id;

    private Integer score;

    private String comment;
    private String verification_status;
    private String verification_reason;

    private java.sql.Timestamp created_at;

    public Rating() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getRater_id() {
        return rater_id;
    }

    public void setRater_id(User rater_id) {
        this.rater_id = rater_id;
    }

    public User getRated_user_id() {
        return rated_user_id;
    }

    public void setRated_user_id(User rated_user_id) {
        this.rated_user_id = rated_user_id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getVerification_status() {
        return verification_status;
    }

    public void setVerification_status(String verification_status) {
        this.verification_status = verification_status;
    }

    public String getVerification_reason() {
        return verification_reason;
    }

    public void setVerification_reason(String verification_reason) {
        this.verification_reason = verification_reason;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
