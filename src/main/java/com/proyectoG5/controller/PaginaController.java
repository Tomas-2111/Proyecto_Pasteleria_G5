package com.proyectoG5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaController {

    @GetMapping("/menu")
    public String mostrarMenu() {
        return "menu"; // Se refiere a menu.html en /resources/templates/
    }
    
    @GetMapping("/historia")
    public String mostrarHistoria() {
        return "Historia"; 
    }
}
