package com.example.abstract_factory;

import com.example.abstract_factory.components.Button;
import com.example.abstract_factory.components.TextField;
import com.example.abstract_factory.factory.GUIFactory;

public class Application {

    private final Button button;
    private final TextField textField;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        textField = factory.creaTextField();
    }

    public void render() {
        button.render();
        textField.render();
    }

    public Button getButton() {
        return button;
    }

    public TextField getTextField(){
        return textField;
    }
    
}
