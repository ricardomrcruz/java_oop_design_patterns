package com.example.factory;

public class EmailNotification implements Notification {

    private final String emailAddress;

    public EmailNotification(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void send(String message) {
        System.out.println("Sending email to " + emailAddress + ": " + message);
    }

    @Override
    public String getChannel() {
        return "EMAIL";
    }

}
