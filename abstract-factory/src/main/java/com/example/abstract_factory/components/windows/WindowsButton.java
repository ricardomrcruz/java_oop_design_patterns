package com.example.abstract_factory.components.windows;

import com.example.abstract_factory.components.Button;

public class WindowsButton implements Button {
    
    @Override
    public void render() {
            //windows specific rendering logic
    }

    @Override
    public void handleClick() {
            //windows specific click handle
    }

    @Override
    public String getStyle() {
        return "Windows default button";
    }
}
