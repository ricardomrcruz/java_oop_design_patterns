package com.example.factory;

public class SMSNotification implements Notification {

    private final String phoneNumber;

    public SMSNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String message) {
        System.out.println("Sending sms to" + phoneNumber + ": " + message );
    }

    @Override
    public String getChannel() {
        return "SMS";
    }
}