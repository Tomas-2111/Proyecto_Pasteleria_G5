/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proyectoG5.controller;

/**
 *
 * @author Tomás Alfaro
 */

import com.proyectoG5.domain.CotizacionPastel;
import com.proyectoG5.service.CotizacionPastelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/cotizacionPastel")
public class CotizacionPastelController {
    
    @Autowired
    private CotizacionPastelService cotizacionPastelService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var cotizacionesPastel = cotizacionPastelService.getCotizacionesPastel();
        model.addAttribute("cotizacionesPastel", cotizacionesPastel);
        model.addAttribute("totalCotizacionesPastel", cotizacionesPastel.size());
        return "/cotizaciones/listado";
    }
    
    
    @PostMapping("/guardar")

}
