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
public class PastelController {

    @GetMapping("/SeccionQueques")
    public String mostrarSeccionQueques() {
        return "SeccionQueques"; // Debe coincidir con el nombre del archivo en templates
    }
}
