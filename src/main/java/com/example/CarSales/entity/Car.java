package com.example.CarSales.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(
        indexes = {
                @Index(name = "idx_car_vin", columnList = "vin", unique = true),
                @Index(name = "idx_car_model_id", columnList = "model_id"),
                @Index(name = "idx_car_color_id", columnList = "color_id")
        }
)
public class Car {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    private Integer year;
    private Integer mileage;

    private String fuelType;
    private String transmission;
    private String driveType;
    private String bodyType;

    private Integer enginePowerHp;
    private String engineSize;

    private String seatMaterial;
    private String seatAdjustment;
    private String headlightType;
    private String climateControlType;
    private String parkingAssistanceLevel;

    @Column(name = "vin", length = 17, unique = true)
    private String vin;

    private Boolean hasNavigation;
    private Boolean hasBluetooth;
    private Boolean hasAppleCarplay;
    private Boolean hasAndroidAuto;
    private Boolean hasCruiseControl;
    private Boolean hasAdaptiveCruiseControl;
    private Boolean hasLaneAssist;
    private Boolean hasBlindSpotMonitor;
    private Boolean hasHeatedSeats;
    private Boolean hasVentilatedSeats;
    private Boolean hasSunroof;
    private Boolean hasPanoramaRoof;
    private Boolean hasKeylessEntry;
    private Boolean hasPushStart;
    private Boolean hasAlloyWheels;
    private Boolean hasAbs;
    private Boolean hasEsp;

    private String description;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Car() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public Integer getEnginePowerHp() {
        return enginePowerHp;
    }

    public void setEnginePowerHp(Integer enginePowerHp) {
        this.enginePowerHp = enginePowerHp;
    }

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }

    public String getSeatMaterial() {
        return seatMaterial;
    }

    public void setSeatMaterial(String seatMaterial) {
        this.seatMaterial = seatMaterial;
    }

    public String getSeatAdjustment() {
        return seatAdjustment;
    }

    public void setSeatAdjustment(String seatAdjustment) {
        this.seatAdjustment = seatAdjustment;
    }

    public String getHeadlightType() {
        return headlightType;
    }

    public void setHeadlightType(String headlightType) {
        this.headlightType = headlightType;
    }

    public String getClimateControlType() {
        return climateControlType;
    }

    public void setClimateControlType(String climateControlType) {
        this.climateControlType = climateControlType;
    }

    public String getParkingAssistanceLevel() {
        return parkingAssistanceLevel;
    }

    public void setParkingAssistanceLevel(String parkingAssistanceLevel) {
        this.parkingAssistanceLevel = parkingAssistanceLevel;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Boolean getHasNavigation() {
        return hasNavigation;
    }

    public void setHasNavigation(Boolean hasNavigation) {
        this.hasNavigation = hasNavigation;
    }

    public Boolean getHasBluetooth() {
        return hasBluetooth;
    }

    public void setHasBluetooth(Boolean hasBluetooth) {
        this.hasBluetooth = hasBluetooth;
    }

    public Boolean getHasAppleCarplay() {
        return hasAppleCarplay;
    }

    public void setHasAppleCarplay(Boolean hasAppleCarplay) {
        this.hasAppleCarplay = hasAppleCarplay;
    }

    public Boolean getHasAndroidAuto() {
        return hasAndroidAuto;
    }

    public void setHasAndroidAuto(Boolean hasAndroidAuto) {
        this.hasAndroidAuto = hasAndroidAuto;
    }

    public Boolean getHasCruiseControl() {
        return hasCruiseControl;
    }

    public void setHasCruiseControl(Boolean hasCruiseControl) {
        this.hasCruiseControl = hasCruiseControl;
    }

    public Boolean getHasAdaptiveCruiseControl() {
        return hasAdaptiveCruiseControl;
    }

    public void setHasAdaptiveCruiseControl(Boolean hasAdaptiveCruiseControl) {
        this.hasAdaptiveCruiseControl = hasAdaptiveCruiseControl;
    }

    public Boolean getHasLaneAssist() {
        return hasLaneAssist;
    }

    public void setHasLaneAssist(Boolean hasLaneAssist) {
        this.hasLaneAssist = hasLaneAssist;
    }

    public Boolean getHasBlindSpotMonitor() {
        return hasBlindSpotMonitor;
    }

    public void setHasBlindSpotMonitor(Boolean hasBlindSpotMonitor) {
        this.hasBlindSpotMonitor = hasBlindSpotMonitor;
    }

    public Boolean getHasHeatedSeats() {
        return hasHeatedSeats;
    }

    public void setHasHeatedSeats(Boolean hasHeatedSeats) {
        this.hasHeatedSeats = hasHeatedSeats;
    }

    public Boolean getHasVentilatedSeats() {
        return hasVentilatedSeats;
    }

    public void setHasVentilatedSeats(Boolean hasVentilatedSeats) {
        this.hasVentilatedSeats = hasVentilatedSeats;
    }

    public Boolean getHasSunroof() {
        return hasSunroof;
    }

    public void setHasSunroof(Boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
    }

    public Boolean getHasPanoramaRoof() {
        return hasPanoramaRoof;
    }

    public void setHasPanoramaRoof(Boolean hasPanoramaRoof) {
        this.hasPanoramaRoof = hasPanoramaRoof;
    }

    public Boolean getHasKeylessEntry() {
        return hasKeylessEntry;
    }

    public void setHasKeylessEntry(Boolean hasKeylessEntry) {
        this.hasKeylessEntry = hasKeylessEntry;
    }

    public Boolean getHasPushStart() {
        return hasPushStart;
    }

    public void setHasPushStart(Boolean hasPushStart) {
        this.hasPushStart = hasPushStart;
    }

    public Boolean getHasAlloyWheels() {
        return hasAlloyWheels;
    }

    public void setHasAlloyWheels(Boolean hasAlloyWheels) {
        this.hasAlloyWheels = hasAlloyWheels;
    }

    public Boolean getHasAbs() {
        return hasAbs;
    }

    public void setHasAbs(Boolean hasAbs) {
        this.hasAbs = hasAbs;
    }

    public Boolean getHasEsp() {
        return hasEsp;
    }

    public void setHasEsp(Boolean hasEsp) {
        this.hasEsp = hasEsp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
