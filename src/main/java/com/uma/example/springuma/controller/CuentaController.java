package com.uma.example.springuma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uma.example.springuma.model.Cuenta;
import com.uma.example.springuma.model.CuentaService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class CuentaController {
    
    @Autowired
    private CuentaService cuentaService;
    
    /*---Anade una nueva cuenta al sistema y vuelve a la pantalla de listar cuentas---*/
	@PostMapping("/cuenta")
	public ResponseEntity<?> saveCuenta(Cuenta cuenta, HttpServletResponse response) {
		try {
			cuentaService.addCuenta(cuenta);
            response.sendRedirect("/listCuenta");
			return ResponseEntity.ok().body("Cuenta creada correctamente");
		} catch (Exception er) {
			return ResponseEntity.status(500).body("Error creando la cuenta: " + er.getMessage());
		}
	}

    /*---Actualiza una cuenta del sistema y vuelve a la pantalla de listas cuentas---*/
	@PutMapping("/cuenta")
    public ResponseEntity<?> updateCuenta(Cuenta cuenta, HttpServletResponse response) {
        try {
            cuentaService.updateCuenta(cuenta);
            response.sendRedirect("/listCuenta");
            return ResponseEntity.ok().body("Cuenta actualizada correctamente");
        } catch (Exception er) {
            return ResponseEntity.status(500).body("Error actualizando la cuenta: " + er.getMessage());
        }
    }


	/*---Elimina una cuenta a partir de su ID y vuelve a la pantalla de listar cuentas---*/
	@DeleteMapping("/cuenta/{id}")
    public ResponseEntity<?> deleteCuenta(@PathVariable("id") Long id, HttpServletResponse response) {
        try {
            cuentaService.removeCuentaID(id);
            response.sendRedirect("/listCuenta");
            return ResponseEntity.ok().body("Cuenta eliminada correctamente");
        } catch (Exception er) {
            return ResponseEntity.status(500).body("Error eliminando la cuenta: " + er.getMessage());
        }
    }
}
