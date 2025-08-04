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
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
public String mostrarLogin(Model model) {
    model.addAttribute("usuario", new Usuario());
    return "usuario/login";
}

    
    

    // Valida los datos del usuario
//    @PostMapping("/validation")
//    public String validarLogin(Usuario usuario, RedirectAttributes redirectAttributes) {
//        Usuario usuarioValidado = usuarioService.getUsuarioByPass(usuario);
//
//        if (usuarioValidado == null) {
//            // Si la validación falla, añadimos un mensaje flash antes de redirigir.
//            redirectAttributes.addFlashAttribute(
//                "error", 
//                "El correo o la contraseña son incorrectos."
//            );
//            return "redirect:/usuario/login";
//        } else {
//            return "redirect:/"; // redirige al inicio u otra vista
//        }
//    }
//    
//    
//     @PostMapping("/register")
//    public String registrar(Usuario usuario,  RedirectAttributes redirectAttributes){
//       
//        if(usuario.getCorreo()!=""&&usuarioService.getUsuarioByCorreo(usuario)==null){
//            usuario.setIdRol(2);
//            usuarioService.save(usuario);
//            return "redirect:/";
//        }else{
//            redirectAttributes.addFlashAttribute(
//                "errorRegistro", 
//                "El correo ya se encuentra registrado"
//            );
//           return "redirect:/usuario/login"; 
//        }
//        
//    }
}
