package com.example.abstract_factory.factory;

import com.example.abstract_factory.components.Button;
import com.example.abstract_factory.components.TextField;

public interface GUIFactory {
    Button createButton();
    TextField creaTextField();
}
