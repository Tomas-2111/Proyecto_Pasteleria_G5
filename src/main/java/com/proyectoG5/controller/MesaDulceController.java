/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoG5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Erick
 */
@Controller
public class MesaDulceController {

    @GetMapping("/MesaDulce")
    public String mostrarMesaDulce() {
        return "mesaDulce"; // nombre del template en src/main/resources/templates/mesaDulce.html
    }
}

