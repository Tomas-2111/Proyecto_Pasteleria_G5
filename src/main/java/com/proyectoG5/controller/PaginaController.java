package com.proyectoG5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaController {

    @GetMapping("/menu")
    public String mostrarMenu() {
        return "menu";
    }

    @GetMapping("/historia")
    public String mostrarHistoria() {
        return "Historia";
    }

    @GetMapping("/contacto")
    public String mostrarContacto() {
        return "Contacto";
    }

    @GetMapping("/cotizaciones")
    public String mostrarCotizaciones() {
        return "Cotizaciones"; // Sin la barra inicial y respetando mayúsculas
}
}
