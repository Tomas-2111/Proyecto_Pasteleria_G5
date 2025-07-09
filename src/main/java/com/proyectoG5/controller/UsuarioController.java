/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proyectoG5.controller;

/**
 *
 * @author Tomás Alfaro
 */
import com.proyectoG5.dao.UsuarioDao;
import com.proyectoG5.domain.Usuario;
import com.proyectoG5.service.UsuarioService;
import com.proyectoG5.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private RolService rolService;
    
    @GetMapping("/login")
    public String inicio(Model model){
        var roles= rolService.getRoles();
        model.addAttribute("roles", roles);
        return "/usuario/login";
    
    }
    
    @PostMapping("/validation")
    public String Login(Usuario usuario){
        Usuario usuarioValidacion=usuarioService.getUsuarioByPass(usuario);
        
        if(usuarioValidacion==null){
            
            return "redirect:/usuario/login";
        }else{
            
            return "redirect:/";
        }
        
    }
    
    @PostMapping("/register")
    public String registrar(Usuario usuario){
        usuarioService.save(usuario);
        return "redirect:/";
    }

}
