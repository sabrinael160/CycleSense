package com.uma.example.springuma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.uma.example.springuma.model.Cuenta;
import com.uma.example.springuma.model.CuentaService;

@Controller
public class CuentaViewController {

	@Autowired
    private CuentaService cuentaService;
	
	/*---Devuelve el formulario de index de cuentas---*/
	@GetMapping("/")
	public String indexCuentaView() {
		return "indexC";
	}

	/*---Devuelve el formulario para anyadir una nueva cuenta con una cuenta vacia---*/
	@GetMapping("/addCuenta")
	public String addCuentaView(Model model) {
		model.addAttribute("cuenta", new Cuenta());
		return "addCuenta";
	}

	/*---Devuelve el formulario para listar las cuentas del sistema---*/
	@GetMapping("/listCuenta")
	public String listCuentaView(Model model) {
		
		model.addAttribute("cuentas", cuentaService.getAllCuentas());
		
		return "listCuenta";
	}


	/*---Devuelve el formulario para editar una Cuenta---*/
	@GetMapping("/editCuenta/{id}")
	public String editCuentaView(@PathVariable("id") Long id, Model model) {

		model.addAttribute("cuenta", cuentaService.getCuenta(id));
		return "updateCuenta";
	}
    
}
