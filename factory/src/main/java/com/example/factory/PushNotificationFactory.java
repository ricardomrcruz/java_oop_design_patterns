package com.example.factory;

public class PushNotificationFactory extends NotificationFactory {
    
    @Override
    public Notification createNotification(String recipient) {
        return new PushNotification(recipient);
    }
}
