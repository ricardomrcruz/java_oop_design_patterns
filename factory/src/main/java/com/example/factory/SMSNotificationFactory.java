package com.example.factory;



public class SMSNotificationFactory extends NotificationFactory {
    
    @Override
    public Notification createNotification(String recipient){
        return new SMSNotification(recipient);
    }
}
