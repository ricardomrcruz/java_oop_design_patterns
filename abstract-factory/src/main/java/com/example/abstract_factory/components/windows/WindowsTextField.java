package com.example.abstract_factory.components.windows;

import com.example.abstract_factory.components.TextField;

public class WindowsTextField implements TextField {

    @Override
    public void render() {
        // windows specific render logic
    }

    @Override
    public void handleInput() {
         // windows specific input handling
    }

    @Override
    public String getStyle() {
        return "Windows Default TextField";
    }
}
