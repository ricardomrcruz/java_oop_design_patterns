package com.example.factory;

public class PushNotification implements Notification {

    private final String deviceToken;
    
    public PushNotification(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    @Override
    public void send(String message) {
        System.out.println("Sending push notif to device "+ deviceToken + ": " + message);
    }

    @Override
    public String getChannel() {
        return "PUSH";
    }
    
}
