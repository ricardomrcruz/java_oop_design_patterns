package com.example.abstract_factory.components.MacOS;

import com.example.abstract_factory.components.TextField;

public class MacOsTextField implements TextField{

    @Override
    public void render() {
         // MacOS-specific rendering logic
    }

    @Override
    public void handleInput() {
        // MacOS-specific input handling
    }

    @Override
    public String getStyle() {
        return "MacOs Default TextField";
    }
    
}
