package com.uma.example.springuma.model;

import com.uma.example.springuma.model.RegistroDolorRepository;
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
    private RegistroDolorRepository registroDolorRepository;

    @InjectMocks
    private RegistroDolorService registroDolorService;

    public RegistroDolorServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("guardar debe llamar al repositorio y devolver el registro")
    void guardar_devuelveRegistro() {
        RegistroDolor registro = new RegistroDolor(1L, 5, "Cabeza", "2025-12-21");
        when(registroDolorRepository.save(registro)).thenReturn(registro);

        RegistroDolor resultado = registroDolorService.guardar(registro);

        assertEquals(registro, resultado);
        verify(registroDolorRepository, times(1)).save(registro);
    }

    @Test
    @DisplayName("buscarPorId devuelve el registro si existe")
    void buscarPorId_devuelveRegistro() {
        RegistroDolor registro = new RegistroDolor(1L, 5, "Cabeza", "2025-12-21");
        when(registroDolorRepository.findById(1L)).thenReturn(Optional.of(registro));

        RegistroDolor resultado = registroDolorService.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals(registro, resultado);
    }

    @Test
    @DisplayName("buscarPorId devuelve null si no existe")
    void buscarPorId_noExiste() {
        when(registroDolorRepository.findById(1L)).thenReturn(Optional.empty());

        RegistroDolor resultado = registroDolorService.buscarPorId(1L);

        assertNull(resultado);
    }

    @Test
    @DisplayName("listar devuelve todos los registros")
    void listar_devuelveLista() {
        RegistroDolor r1 = new RegistroDolor(1L, 5, "Cabeza", "2025-12-21");
        RegistroDolor r2 = new RegistroDolor(2L, 3, "Espalda", "2025-12-20");
        when(registroDolorRepository.findAll()).thenReturn(Arrays.asList(r1, r2));

        var resultado = registroDolorService.listar();

        assertEquals(2, resultado.size());
        verify(registroDolorRepository, times(1)).findAll();
    }
}

