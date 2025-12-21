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

class CuentaServiceTest {

    @Mock
    private RepositoryCuenta repositoryCuenta;

    @InjectMocks
    private CuentaService cuentaService;

    public CuentaServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("getAllCuentas devuelve todas las cuentas")
    void getAllCuentas_devuelveLista() {
        Cuenta c1 = new Cuenta(111);
        Cuenta c2 = new Cuenta(222);

        when(repositoryCuenta.findAll()).thenReturn(Arrays.asList(c1, c2));

        var resultado = cuentaService.getAllCuentas();

        assertEquals(2, resultado.size());
        verify(repositoryCuenta, times(1)).findAll();
    }

    @Test
    @DisplayName("getCuenta devuelve la cuenta por ID")
    void getCuenta_devuelveCuenta() {
        Cuenta cuenta = new Cuenta(123);
        when(repositoryCuenta.getReferenceById(1L)).thenReturn(cuenta);

        Cuenta resultado = cuentaService.getCuenta(1L);

        assertEquals(cuenta, resultado);
    }

    @Test
    @DisplayName("addCuenta guarda y devuelve la cuenta")
    void addCuenta_guardaCuenta() {
        Cuenta cuenta = new Cuenta(123);
        when(repositoryCuenta.saveAndFlush(cuenta)).thenReturn(cuenta);

        Cuenta resultado = cuentaService.addCuenta(cuenta);

        assertEquals(cuenta, resultado);
        verify(repositoryCuenta, times(1)).saveAndFlush(cuenta);
    }

    @Test
    @DisplayName("updateCuenta actualiza correctamente los campos")
    void updateCuenta_actualiza() {
        Cuenta original = new Cuenta(1L, 100.0, "CCC1");
        Cuenta cambios = new Cuenta(1L, 200.0, "CCC2");

        when(repositoryCuenta.getReferenceById(1L)).thenReturn(original);

        cuentaService.updateCuenta(cambios);

        assertEquals(200.0, original.getBalance());
        assertEquals("CCC2", original.getCcc());
        verify(repositoryCuenta, times(1)).saveAndFlush(original);
    }

    @Test
    @DisplayName("removeCuenta elimina la cuenta")
    void removeCuenta_elimina() {
        Cuenta cuenta = new Cuenta(123);

        cuentaService.removeCuenta(cuenta);

        verify(repositoryCuenta, times(1)).delete(cuenta);
    }

    @Test
    @DisplayName("removeCuentaID elimina por ID")
    void removeCuentaID_eliminaPorId() {
        cuentaService.removeCuentaID(1L);

        verify(repositoryCuenta, times(1)).deleteById(1L);
    }
}
