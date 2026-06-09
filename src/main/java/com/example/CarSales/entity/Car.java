package com.example.CarSales.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(
        indexes = {
                @Index(columnList = "VIN", unique = true)
        })
public class Car {

    // Car
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Model model_id;

    @ManyToOne
    private Color color_id;
    private Integer year;
    private Integer mileage;
    private String fuel_type;
    private String transmission;
    private String drive_type;
    private String body_type;
    private Integer engine_power_hp;
    private String engine_size;
    private String seat_material;
    private String seat_adjustment;
    private String headlight_type;
    private String climate_control_type;
    private String parking_assistance_level;

    private Long VIN;

    private Boolean has_navigation;
    private Boolean has_bluetooth;
    private Boolean has_apple_carplay;
    private Boolean has_android_auto;
    private Boolean has_cruise_control;
    private Boolean has_adaptive_cruise_control;
    private Boolean has_lane_assist;
    private Boolean has_blind_spot_monitor;
    private Boolean has_heated_seats;
    private Boolean has_ventilated_seats;
    private Boolean has_sunroof;
    private Boolean has_panorama_roof;
    private Boolean has_keyless_entry;
    private Boolean has_push_start;
    private Boolean has_alloy_wheels;
    private Boolean has_abs;
    private Boolean has_esp;

    private String description;

    private java.sql.Timestamp created_at;
    private java.sql.Timestamp updated_at;

    public Car() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getVIN() {
        return VIN;
    }

    public void setVIN(Long VIN) {
        this.VIN = VIN;
    }

    public Model getModel_id() {
        return model_id;
    }

    public void setModel_id(Model model_id) {
        this.model_id = model_id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Color getColor_id() {
        return color_id;
    }

    public void setColor_id(Color color_id) {
        this.color_id = color_id;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getDrive_type() {
        return drive_type;
    }

    public void setDrive_type(String drive_type) {
        this.drive_type = drive_type;
    }

    public String getBody_type() {
        return body_type;
    }

    public void setBody_type(String body_type) {
        this.body_type = body_type;
    }

    public Integer getEngine_power_hp() {
        return engine_power_hp;
    }

    public void setEngine_power_hp(Integer engine_power_hp) {
        this.engine_power_hp = engine_power_hp;
    }

    public String getEngine_size() {
        return engine_size;
    }

    public void setEngine_size(String engine_size) {
        this.engine_size = engine_size;
    }

    public String getSeat_material() {
        return seat_material;
    }

    public void setSeat_material(String seat_material) {
        this.seat_material = seat_material;
    }

    public String getSeat_adjustment() {
        return seat_adjustment;
    }

    public void setSeat_adjustment(String seat_adjustment) {
        this.seat_adjustment = seat_adjustment;
    }

    public String getHeadlight_type() {
        return headlight_type;
    }

    public void setHeadlight_type(String headlight_type) {
        this.headlight_type = headlight_type;
    }

    public String getClimate_control_type() {
        return climate_control_type;
    }

    public void setClimate_control_type(String climate_control_type) {
        this.climate_control_type = climate_control_type;
    }

    public String getParking_assistance_level() {
        return parking_assistance_level;
    }

    public void setParking_assistance_level(String parking_assistance_level) {
        this.parking_assistance_level = parking_assistance_level;
    }

    public Boolean getHas_navigation() {
        return has_navigation;
    }

    public void setHas_navigation(Boolean has_navigation) {
        this.has_navigation = has_navigation;
    }

    public Boolean getHas_bluetooth() {
        return has_bluetooth;
    }

    public void setHas_bluetooth(Boolean has_bluetooth) {
        this.has_bluetooth = has_bluetooth;
    }

    public Boolean getHas_apple_carplay() {
        return has_apple_carplay;
    }

    public void setHas_apple_carplay(Boolean has_apple_carplay) {
        this.has_apple_carplay = has_apple_carplay;
    }

    public Boolean getHas_android_auto() {
        return has_android_auto;
    }

    public void setHas_android_auto(Boolean has_android_auto) {
        this.has_android_auto = has_android_auto;
    }

    public Boolean getHas_cruise_control() {
        return has_cruise_control;
    }

    public void setHas_cruise_control(Boolean has_cruise_control) {
        this.has_cruise_control = has_cruise_control;
    }

    public Boolean getHas_adaptive_cruise_control() {
        return has_adaptive_cruise_control;
    }

    public void setHas_adaptive_cruise_control(Boolean has_adaptive_cruise_control) {
        this.has_adaptive_cruise_control = has_adaptive_cruise_control;
    }

    public Boolean getHas_lane_assist() {
        return has_lane_assist;
    }

    public void setHas_lane_assist(Boolean has_lane_assist) {
        this.has_lane_assist = has_lane_assist;
    }

    public Boolean getHas_blind_spot_monitor() {
        return has_blind_spot_monitor;
    }

    public void setHas_blind_spot_monitor(Boolean has_blind_spot_monitor) {
        this.has_blind_spot_monitor = has_blind_spot_monitor;
    }

    public Boolean getHas_heated_seats() {
        return has_heated_seats;
    }

    public void setHas_heated_seats(Boolean has_heated_seats) {
        this.has_heated_seats = has_heated_seats;
    }

    public Boolean getHas_sunroof() {
        return has_sunroof;
    }

    public void setHas_sunroof(Boolean has_sunroof) {
        this.has_sunroof = has_sunroof;
    }

    public Boolean getHas_ventilated_seats() {
        return has_ventilated_seats;
    }

    public void setHas_ventilated_seats(Boolean has_ventilated_seats) {
        this.has_ventilated_seats = has_ventilated_seats;
    }

    public Boolean getHas_panorama_roof() {
        return has_panorama_roof;
    }

    public void setHas_panorama_roof(Boolean has_panorama_roof) {
        this.has_panorama_roof = has_panorama_roof;
    }

    public Boolean getHas_keyless_entry() {
        return has_keyless_entry;
    }

    public void setHas_keyless_entry(Boolean has_keyless_entry) {
        this.has_keyless_entry = has_keyless_entry;
    }

    public Boolean getHas_push_start() {
        return has_push_start;
    }

    public void setHas_push_start(Boolean has_push_start) {
        this.has_push_start = has_push_start;
    }

    public Boolean getHas_alloy_wheels() {
        return has_alloy_wheels;
    }

    public void setHas_alloy_wheels(Boolean has_alloy_wheels) {
        this.has_alloy_wheels = has_alloy_wheels;
    }

    public Boolean getHas_abs() {
        return has_abs;
    }

    public void setHas_abs(Boolean has_abs) {
        this.has_abs = has_abs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getHas_esp() {
        return has_esp;
    }

    public void setHas_esp(Boolean has_esp) {
        this.has_esp = has_esp;
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
