package com.example.abstract_factory.factory;

import com.example.abstract_factory.components.Button;
import com.example.abstract_factory.components.TextField;
import com.example.abstract_factory.components.windows.WindowsButton;
import com.example.abstract_factory.components.windows.WindowsTextField;

public class WindowsFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public TextField creaTextField() {
        return new WindowsTextField();
    }
    
}
