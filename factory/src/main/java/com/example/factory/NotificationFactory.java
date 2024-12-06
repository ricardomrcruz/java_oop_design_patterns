package com.example.factory;

public abstract class NotificationFactory {
    
    abstract Notification createNotification(String recipient);

    public void sendNotification(String recipient, String message) {
        Notification notification = createNotification(recipient);
        notification.send(message);
    }


}
