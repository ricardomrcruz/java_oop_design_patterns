package com.example.factory;

public class EmailNotificationFactory extends  NotificationFactory {

    @Override
    public Notification createNotification(String recipient) {
        return new EmailNotification(recipient);
    }
    
}
