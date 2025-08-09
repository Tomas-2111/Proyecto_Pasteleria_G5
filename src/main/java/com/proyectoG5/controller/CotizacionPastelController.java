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
import com.proyectoG5.domain.Usuario;
import com.proyectoG5.service.CotizacionPastelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.multipart.MultipartFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Arrays;

@Controller
@Slf4j
@RequestMapping("/cotizacionPastel")
public class CotizacionPastelController {
    
    @Autowired
    private CotizacionPastelService cotizacionPastelService;
    
    private Usuario usuario=new Usuario();
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var cotizacionesPastel = cotizacionPastelService.getCotizacionesPastel();
        model.addAttribute("cotizacionesPastel", cotizacionesPastel);
        model.addAttribute("totalCotizacionesPastel", cotizacionesPastel.size());
        return "/cotizacionPastel/listado";
    }
    
    
    @PostMapping("/guardar")
    public String guardarCotizacionPastel(
            CotizacionPastel cotizacionPastel,
           // @RequestParam('imagenDiseno') MultipartFile imagenDiseno,
            Model model){
        
        StringBuilder descripcionBuilder = new StringBuilder();
        
        if(cotizacionPastel.getTamano()!=null){
            descripcionBuilder.append("Tamaño: ").append(cotizacionPastel.getTamano()).append(" - ");
            
        }
        if(cotizacionPastel.getSabor()!=null){
            descripcionBuilder.append("Sabor: ").append(cotizacionPastel.getSabor()).append(" - ");
            
        }
        if(cotizacionPastel.getRelleno()!=null){
            descripcionBuilder.append("Relleno: ").append(cotizacionPastel.getRelleno()).append(" - ");
            
        }
        if(cotizacionPastel.getCubierta()!=null){
                descripcionBuilder.append("Cubierta: ").append(cotizacionPastel.getCubierta()).append(" - ");
            
        }
        if(cotizacionPastel.getExtras()!=null){
                descripcionBuilder.append("Ingredientes Extras: ");
                descripcionBuilder.append(String.join(", ",cotizacionPastel.getExtras()));
                
        }
        
        
        if(cotizacionPastel.getId()==null)//Si es create o modificar
        {
            cotizacionPastel.setDescripcion(descripcionBuilder.toString().trim());
            cotizacionPastel.setUrl_imagen(null);
            cotizacionPastel.setEstado("Pendiente Revision");
            //usuario.setIdUsuario((long) 2);
            //cotizacionPastel.setUsuario(usuario);
        }
        cotizacionPastelService.save(cotizacionPastel);
        return "redirect:/cotizacionPastel/listado";
        
    }
    
    @GetMapping("/modificar/{id}")
    public String cotizacionPastelModificar( CotizacionPastel cotizacionPastel, Model model) {
        cotizacionPastel = cotizacionPastelService.getCotizacionPastel(cotizacionPastel);
        model.addAttribute("cotizacionPastel", cotizacionPastel);
        return "/cotizacionPastel/modifica";
    } 

}
