package com.example.CarSales.enums;

public enum UserStatus {
    ACTIVE(1, "Account is active"),
    UNAPPROVED(2, "Email verification is pending"),
    SUSPENDED(3, "Account is temporarily suspended"),
    DEACTIVATED(4, "Account has been deactivated");

    private final int code;
    private final String description;

    UserStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
