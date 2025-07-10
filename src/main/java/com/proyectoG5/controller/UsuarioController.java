package com.proyectoG5.controller;

import com.proyectoG5.domain.Usuario;
import com.proyectoG5.service.UsuarioService;
import com.proyectoG5.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
     @Autowired
    private RolService rolService;
    

    // Muestra el formulario de login
    @GetMapping("/login")
    public String mostrarLogin() {
        return "usuario/login"; // ✅ Sin "/" al inicio
    }

    // Valida los datos del usuario
    @PostMapping("/validation")
    public String validarLogin(Usuario usuario) {
        Usuario usuarioValidado = usuarioService.getUsuarioByPass(usuario);

        if (usuarioValidado == null) {
            return "redirect:/usuario/login";
        } else {
            return "redirect:/"; // redirige al inicio u otra vista
        }
    }
    
    
     @PostMapping("/register")
    public String registrar(Usuario usuario){
       
        if(usuarioService.getUsuarioByCorreo(usuario)==null){
            usuario.setIdRol(2);
            usuarioService.save(usuario);
            return "redirect:/";
        }else{
           return "redirect:/usuario/login"; 
        }
        
    }
}
