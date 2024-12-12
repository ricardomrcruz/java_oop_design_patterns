package com.example.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ComputerBuilderTest {

    @Test
    @DisplayName("Should build basic computer with required parameters.")
    void buildBasicComputer() {
        Computer computer = new Computer.Builder("Intel i5-12600k", 16)
            .build();
        
        assertEquals("Intel i5-12600k", computer.getCpu());
        assertEquals(16, computer.getRamGB());
        assertEquals("Integrated Graphics", computer.getGpu()); //default value
        assertFalse(computer.hasWiFi()); //test default values

    }

    @Test
    @DisplayName("Should build fully configured gaming pc")
    void buildGamingComputer() {

        Computer computer = new Computer.Builder("Intel i7-12700k", 32)
            .gpu("NVIDIA RTX 4080")
            .storage("2TB NVMe SSD")  
            .motherboard("ASUS ROG Z690")
            .powerSupply("850W")
            .cooling("Liquid Cooling")
            .withWiFi()
            .withBluetooth()
            .build();

        assertEquals("Intel i7-12700k", computer.getCpu());
        assertEquals(32, computer.getRamGB());
        assertEquals("NVIDIA RTX 4080", computer.getGpu());
        assertEquals("2TB NVMe SSD", computer.getStorage());
        assertTrue(computer.hasWiFi());
        assertTrue(computer.hasBluetooth());
    }

    @Test
    @DisplayName("Should throw exception for null CPU")
    void validateRequiredCPU() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->{
            new Computer.Builder(null, 16).build();
        });
        assertEquals("CPU specification is required", exception.getMessage());
    }


    @Test
    @DisplayName("Should throw exception for invalid RAM")
    void validateRequiredRAM() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
            new Computer.Builder("Intel i5-12600k", 0).build();
        });
        assertEquals("RAM must be atleast 1GB", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw exception for insufficient power supply with RTX GPU")
    void validatePowerSupplyForRtxGpu() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, ()->{
            new Computer.Builder("Intel i5-12600k", 16)
            .gpu("NVIDIA RTX 4080")
            .powerSupply("500W")
            .build();
        });
        assertEquals("RTX GPUs require at least 650W per supply", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw exception for i9 with air cooling")
    void validateCoolingi9() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, ()->{
            new Computer.Builder("Intel i9-12900k", 32)
            .cooling("Air Cooling")
            .build();
        });
        assertEquals("i9 processors require liquid cooling", exception.getMessage());
    }

    @Test
    @DisplayName("Should ignore null optional parameters")
    void handleNullOptionalParameters() {
        Computer computer = new Computer.Builder("Intel i5-12600k", 16)
            .gpu(null)
            .storage(null)
            .build();

        assertEquals("Integrated Graphics", computer.getGpu());
        assertEquals(
            "256GB SSD", computer.getStorage()
        );
    }



    
    
}
