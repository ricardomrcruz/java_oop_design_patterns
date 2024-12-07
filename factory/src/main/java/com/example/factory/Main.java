package com.example.factory;

public class Main {
    public static void main(String[] args) {
        
        //Create factories
        NotificationFactory emailFactory = new EmailNotificationFactory();
        NotificationFactory smsFactory   = new SMSNotificationFactory();
        NotificationFactory pushFactory  = new PushNotificationFactory();

        //Send notificatiosns
        emailFactory.sendNotification("user@example.com", "Welcome email!");
        smsFactory.sendNotification("+1234567890", "Your verification code: 123456");
        pushFactory.sendNotification("device-token", "new message received!");

    }
}