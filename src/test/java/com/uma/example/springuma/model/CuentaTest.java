package com.uma.example.springuma.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    @DisplayName("Getters y setters funcionan correctamente")
    void gettersSetters_funcionan() {
        // Arrange
        Cuenta cuenta = new Cuenta();
        Persona persona = new Persona();

        // Act
        cuenta.setId(1L);
        cuenta.setBalance(150.75);
        cuenta.setCcc(12345);
        cuenta.setTitular(persona);

        // Assert
        assertEquals(1L, cuenta.getId());
        assertEquals(150.75, cuenta.getBalance());
        assertEquals(12345, cuenta.getCcc());
        assertEquals(persona, cuenta.getTitular());
    }

    @Test
    @DisplayName("Constructor con CCC asigna correctamente el valor")
    void constructorCCC_asignaValor() {
        // Arrange & Act
        Cuenta cuenta = new Cuenta(999);

        // Assert
        assertEquals(999, cuenta.getCcc());
    }
}
