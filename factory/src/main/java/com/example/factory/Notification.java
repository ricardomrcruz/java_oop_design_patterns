
package com.example.factory;

public interface Notification {
    void send(String message);

    String getChannel();
}