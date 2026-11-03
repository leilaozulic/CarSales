package com.example.CarSales.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "model")
public class CarModel {

    // CarModel
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "make_id")
    private Make make;
    private String name;

    public CarModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make_id) {
        this.make = make_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


