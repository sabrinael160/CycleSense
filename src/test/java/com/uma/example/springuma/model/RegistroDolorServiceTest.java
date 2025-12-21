package com.uma.example.springuma.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RegistroDolorServiceTest {

    @Mock
    private RegistroDolorRepository repository;

    @InjectMocks
    private RegistroDolorService service;

    public RegistroDolorServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("findAll devuelve todos los registros")
    void findAll_devuelveLista() {
        RegistroDolor r1 = new RegistroDolor();
        RegistroDolor r2 = new RegistroDolor();

        when(repository.findAll()).thenReturn(Arrays.asList(r1, r2));

        var resultado = service.findAll();

        assertEquals(2, resultado.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    @DisplayName("findById devuelve el registro si existe")
    void findById_devuelveRegistro() {
        RegistroDolor r = new RegistroDolor();
        when(repository.findById(1L)).thenReturn(Optional.of(r));

        RegistroDolor resultado = service.findById(1L);

        assertEquals(r, resultado);
    }

    @Test
    @DisplayName("findById devuelve null si no existe")
    void findById_noExiste() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        RegistroDolor resultado = service.findById(1L);

        assertNull(resultado);
    }

    @Test
    @DisplayName("save guarda el registro")
    void save_guardaRegistro() {
        RegistroDolor r = new RegistroDolor();

        service.save(r);

        verify(repository, times(1)).save(r);
    }

    @Test
    @DisplayName("deleteById elimina por ID")
    void deleteById_elimina() {
        service.deleteById(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}
