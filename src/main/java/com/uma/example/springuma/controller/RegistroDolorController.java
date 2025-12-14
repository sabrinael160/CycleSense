package com.uma.example.springuma.controller;

import com.uma.example.springuma.model.RegistroDolor;
import com.uma.example.springuma.model.RegistroDolorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registros")
public class RegistroDolorController {

    private final RegistroDolorService service;

    public RegistroDolorController(RegistroDolorService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("registros", service.findAll());
        return "listRegistros";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("registro", new RegistroDolor());
        return "formRegistro";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute RegistroDolor registro) {
        service.save(registro);
        return "redirect:/registros";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("registro", service.findById(id));
        return "formRegistro";
    }

    @GetMapping("/borrar/{id}")
    public String borrar(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/registros";
    }
}
