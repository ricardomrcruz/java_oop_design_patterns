package com.example.abstract_factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.abstract_factory.components.Button;
import com.example.abstract_factory.components.TextField;
import com.example.abstract_factory.factory.GUIFactory;
import com.example.abstract_factory.factory.MacOsFactory;
import com.example.abstract_factory.factory.WindowsFactory;

class AbstractFactoryTest {

    @Test
    void testWindowsComponents() {
        GUIFactory factory = new WindowsFactory();
        Application app = new Application(factory);

        Button button = app.getButton();
        TextField textField = app.getTextField();

        assertEquals("Windows default button", button.getStyle());
        assertEquals("Windows Default TextField", textField.getStyle());
    }


    @Test
    void testMacOsComponents() {
        GUIFactory factory = new MacOsFactory();
        Application app = new Application(factory);

        Button button = app.getButton();
        TextField textField = app.getTextField();

        assertEquals("MacOS default button", button.getStyle());
        assertEquals("MacOS Default TextField", textField.getStyle());
    }

    @Test
    void testComponentFamilyConsistency() {
        GUIFactory windowsFactory = new WindowsFactory();
        Application windowsApp = new Application(windowsFactory);

        assertTrue(windowsApp.getButton().getStyle().startsWith("Windows"));
        assertTrue(windowsApp.getTextField().getStyle().startsWith("Windows"));


        GUIFactory macOsFactory = new MacOsFactory();
        Application macOsApp = new Application(macOsFactory);

        assertTrue(macOsApp.getButton().getStyle().startsWith("MacOS"));
        assertTrue(macOsApp.getTextField().getStyle().startsWith("MacOS"));
    }
    
}
