package com.example.abstract_factory.components.MacOS;

import com.example.abstract_factory.components.Button;

public class MacOsButton implements Button{
    
    @Override
    public void render() {
        //macos specific rendering logic
    }

    @Override
    public void handleClick() {
        //macos specific click handle
    }

    @Override
    public String getStyle() {
        return "MacOS default button";
    }

}
