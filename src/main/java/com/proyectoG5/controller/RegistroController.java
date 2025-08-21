/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proyectoG5.controller;


import com.proyectoG5.domain.Usuario;
import com.proyectoG5.service.UsuarioService;
import com.proyectoG5.service.RegistroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes; 

@Controller
@Slf4j
@RequestMapping("/registro")
public class RegistroController {
    
    @Autowired
    private RegistroService registroService;
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registrar")
    public String registro() {
        return "/registro/registrar";
    }
    
    @PostMapping("/nuevo")
    public String nuevo(Usuario usuario, RedirectAttributes redirectAttributes) {
        if(!usuarioService.existeUsuarioPorUsernameOCorreo(
                        usuario.getUsername(), 
                        usuario.getCorreo())){
            registroService.crearUsuario(usuario);
        }else{
            redirectAttributes.addFlashAttribute(
                "errorRegistro", 
                "Usuario con username o correo ya existente"
            );
            return "redirect:/registro/registrar";
        }
        return "redirect:/login";
    }

}
