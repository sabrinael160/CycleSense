package com.uma.example.springuma.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {

    @Test
    @DisplayName("Getters y setters funcionan correctamente")
    void gettersSetters_funcionan() {
        // Arrange
        Persona persona = new Persona();

        // Act
        persona.setId(10L);
        persona.setNombre("Ana");
        persona.setDni("12345678A");
        persona.setEdad(30);

        // Assert
        assertEquals(10L, persona.getId());
        assertEquals("Ana", persona.getNombre());
        assertEquals("12345678A", persona.getDni());
        assertEquals(30, persona.getEdad());
    }
}
