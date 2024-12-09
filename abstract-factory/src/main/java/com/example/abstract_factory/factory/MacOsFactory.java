package com.example.abstract_factory.factory;

import com.example.abstract_factory.components.Button;
import com.example.abstract_factory.components.MacOS.MacOsButton;
import com.example.abstract_factory.components.MacOS.MacOsTextField;
import com.example.abstract_factory.components.TextField;

public class MacOsFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacOsButton();
    }

    @Override
    public TextField creaTextField() {
        return new MacOsTextField();
    }
}