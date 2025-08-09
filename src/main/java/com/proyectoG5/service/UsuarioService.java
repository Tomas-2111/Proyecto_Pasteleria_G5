/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.proyectoG5.service;

/**
 *
 * @author Tomás Alfaro
 */

import com.proyectoG5.domain.Usuario;
import java.util.List;

public interface UsuarioService {
    
    //public List<Usuario> getUsuarios();
    
    public Usuario getUsuarioByPass(Usuario usuario);
    
    public void save(Usuario usuario);
    
    public Usuario getUsuarioByCorreo(Usuario usuario0);
       // Se obtiene un Usuario, a partir del username de un usuario
    public Usuario getUsuarioPorUsername(String username);


}
