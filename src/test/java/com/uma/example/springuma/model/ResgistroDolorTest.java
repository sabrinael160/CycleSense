package com.uma.example.springuma.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroDolorTest {

    @Test
    @DisplayName("Getters y setters funcionan correctamente")
    void gettersSetters_funcionan() {
        // Arrange
        RegistroDolor registro = new RegistroDolor();

        // Act
        registro.setId(5L);
        registro.setIntensidad(8);
        registro.setZona("Espalda");
        registro.setSintomas("Dolor punzante");

        // Assert
        assertEquals(5L, registro.getId());
        assertEquals(8, registro.getIntensidad());
        assertEquals("Espalda", registro.getZona());
        assertEquals("Dolor punzante", registro.getSintomas());
    }
}
