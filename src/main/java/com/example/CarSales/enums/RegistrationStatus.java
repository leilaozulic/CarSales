package com.example.CarSales.enums;

public enum RegistrationStatus {

    SUCCESS("Successfully registered!"),
    USERNAME_EXISTS("This username is already taken."),
    EMAIL_EXISTS("An account with this email already exists.");

    private final String statusMessage;

    RegistrationStatus(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
}