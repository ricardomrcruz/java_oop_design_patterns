package com.example.factory;

public class SMSNotification implements Notification {

    private final String phoneNumber;f

    public SMSNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}