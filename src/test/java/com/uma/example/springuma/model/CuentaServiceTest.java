package com.uma.example.springuma.model;
import com.uma.example.springuma.model.RepositoryCuenta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CuentaServiceTest {

    @Mock
    private RepositoryCuenta repositoryCuenta;

    @InjectMocks
    private CuentaService cuentaService;

    public CuentaServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("guardar debe llamar al repositorio y devolver la cuenta")
    void guardar_devuelveCuenta() {
        Cuenta cuenta = new Cuenta(123);
        when(repositoryCuenta.save(cuenta)).thenReturn(cuenta);

        Cuenta resultado = cuentaService.guardar(cuenta);

        assertEquals(cuenta, resultado);
        verify(repositoryCuenta, times(1)).save(cuenta);
    }

    @Test
    @DisplayName("buscarPorId devuelve la cuenta si existe")
    void buscarPorId_devuelveCuenta() {
        Cuenta cuenta = new Cuenta(123);
        when(repositoryCuenta.findById(1L)).thenReturn(Optional.of(cuenta));

        Cuenta resultado = cuentaService.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals(cuenta, resultado);
    }

    @Test
    @DisplayName("buscarPorId devuelve null si no existe")
    void buscarPorId_noExiste() {
        when(repositoryCuenta.findById(1L)).thenReturn(Optional.empty());

        Cuenta resultado = cuentaService.buscarPorId(1L);

        assertNull(resultado);
    }

    @Test
    @DisplayName("listar devuelve todas las cuentas")
    void listar_devuelveLista() {
        Cuenta c1 = new Cuenta(111);
        Cuenta c2 = new Cuenta(222);
        when(repositoryCuenta.findAll()).thenReturn(Arrays.asList(c1, c2));

        var resultado = cuentaService.listar();

        assertEquals(2, resultado.size());
        verify(repositoryCuenta, times(1)).findAll();
    }
}
