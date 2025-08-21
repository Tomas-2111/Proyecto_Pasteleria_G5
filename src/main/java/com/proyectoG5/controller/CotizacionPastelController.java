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
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    
    @GetMapping("/listadoUsuario")
    public String listadoUsuario(Model model) {
        var cotizacionesPastel = cotizacionPastelService.getCotizacionesPastelUsuario();
        model.addAttribute("cotizacionesPastel", cotizacionesPastel);
        model.addAttribute("totalCotizacionesPastel", cotizacionesPastel.size());
        return "/cotizacionPastel/listadoUsuario";
    }
    
    @GetMapping("/nueva")
    public String nuevaPastel() {
       
        return "/cotizacionPastel/nueva";
    }
    
    
    
   @PostMapping("/guardar")
public String guardarCotizacionPastel(
        CotizacionPastel cotizacionPastel,
        @RequestParam("imagenReferencia") MultipartFile imagenDiseno,
        Model model) {

        
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
        
        
     // Guardar imagen si se subió (para cuando el cliente sube una imagen en cotizacion de pasteles)
    try {
        if (!imagenDiseno.isEmpty()) {
            String carpeta = "src/main/resources/static/images/cotizaciones/";
            String nombreArchivo = imagenDiseno.getOriginalFilename();
            Path rutaArchivo = Paths.get(carpeta + nombreArchivo);
            Path createDirectories = Files.createDirectories(rutaArchivo.getParent());
            //Files.createDirectories(rutaArchivo.getParent());
            imagenDiseno.transferTo(rutaArchivo.toFile());
            cotizacionPastel.setUrl_imagen("/images/cotizaciones/" + nombreArchivo);
        }
    } catch (Exception e) {
        e.printStackTrace();
        cotizacionPastel.setUrl_imagen(null);
    }

    if (cotizacionPastel.getId() == null) {
        cotizacionPastel.setDescripcion(descripcionBuilder.toString().trim());
        cotizacionPastel.setEstado("Pendiente Revision");
    }

    cotizacionPastelService.save(cotizacionPastel);
    return "redirect:/index";
}
    
    @GetMapping("/modificar/{id}")
    public String cotizacionPastelModificar( CotizacionPastel cotizacionPastel, Model model) {
        cotizacionPastel = cotizacionPastelService.getCotizacionPastel(cotizacionPastel);
        model.addAttribute("cotizacionPastel", cotizacionPastel);
        return "/cotizacionPastel/modifica";
    } 

}