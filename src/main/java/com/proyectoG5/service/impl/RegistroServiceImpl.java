/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proyectoG5.service.impl;

import com.proyectoG5.domain.Usuario;
import com.proyectoG5.domain.Rol;
import com.proyectoG5.service.RegistroService;
import com.proyectoG5.service.UsuarioService;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RegistroServiceImpl implements RegistroService{
    @Autowired
    private UsuarioService usuarioService;
    
    
    @Override
    public void crearUsuario(Usuario usuario){
        var codigo = new BCryptPasswordEncoder(); 
        Rol rol= new Rol();
        usuario.setPassword(codigo.encode(usuario.getPassword()));
        rol.setId_rol((long) 2);
        usuario.setRol(rol);
        usuarioService.save(usuario);
        
            
        
    }

}
