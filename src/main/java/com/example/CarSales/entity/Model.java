package com.example.CarSales.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "model")
public class Model {

    // Model
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Make make_id;
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
        return make_id;
    }

    public void setMake_id(Make make_id) {
        this.make_id = make_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


