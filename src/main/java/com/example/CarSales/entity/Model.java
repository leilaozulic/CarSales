package com.example.CarSales.entity;

import jakarta.persistence.*;

@Entity
public class Model {

    // Model
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "make_id")
    private Make make;
    private String name;

    public Model() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Make getMake_id() {
        return make;
    }

    public void setMake_id(Make make_id) {
        this.make = make_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


