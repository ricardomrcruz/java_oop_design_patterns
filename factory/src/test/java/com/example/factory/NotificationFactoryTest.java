package com.example.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class NotificationFactoryTest {
    
    @Test
    void testEmailNotificationFactory() {
        NotificationFactory factory = new EmailNotificationFactory();
        Notification notification = factory.createNotification("user@example.com");

        assertNotNull(notification);
        assertTrue(notification instanceof EmailNotification);
        assertEquals("EMAIL", notification.getChannel());
    }

    @Test
    void testSMSNotificationFactory() {
        NotificationFactory factory = new SMSNotificationFactory();
        Notification notification = factory.createNotification("+1234567890");

        assertNotNull(notification);
        assertTrue(notification instanceof SMSNotification);
        assertEquals("SMS", notification.getChannel());

    }

    @Test
    void testPushNotificationFactory() {
        NotificationFactory factory = new PushNotificationFactory();
        Notification notification = factory.createNotification("device-token");

        assertNotNull(notification);
        assertTrue(notification instanceof PushNotification);
        assertEquals("PUSH", notification.getChannel());

    }

    
}
