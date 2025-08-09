/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proyectoG5.controller;

/**
 *
 * @author Tomás Alfaro
 */
import com.proyectoG5.domain.CotizacionReposteria;
import com.proyectoG5.service.CotizacionReposteriaService;
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
@RequestMapping("/cotizacionReposteria")
public class CotizacionReposteriaController {
    
     @Autowired
    private CotizacionReposteriaService cotizacionReposteriaService;
     
    //private Usuario usuario=new Usuario();
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var cotizacionesReposteria = cotizacionReposteriaService.getCotizacionesReposteria();
        model.addAttribute("cotizacionesReposteria", cotizacionesReposteria);
        model.addAttribute("totalCotizacionesReposteria", cotizacionesReposteria.size());
        return "/cotizacionReposteria/listado";
    }
    
    
    @PostMapping("/guardar")
    public String guardarCotizacionReposteria(CotizacionReposteria cotizacionReposteria){
        if(cotizacionReposteria.getId()==null)//Si es create o modificar
        {
            
            cotizacionReposteria.setEstado("Pendiente Revision");
            //usuario.setIdUsuario((long) 2);
            //cotizacionReposteria.setUsuario(usuario);
        }
        
        
        cotizacionReposteriaService.save(cotizacionReposteria);
        return "redirect:/cotizacionReposteria/listado";
        
    }
    
    @GetMapping("/modificar/{id}")
    public String cotizacionReposteriaModificar( CotizacionReposteria cotizacionReposteria, Model model) {
        cotizacionReposteria = cotizacionReposteriaService.getCotizacionReposteria(cotizacionReposteria);
        model.addAttribute("cotizacionReposteria", cotizacionReposteria);
        return "/cotizacionReposteria/modifica";
    } 

}
