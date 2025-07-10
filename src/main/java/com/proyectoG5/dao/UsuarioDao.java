/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.proyectoG5.dao;

/**
 *
 * @author Tomás Alfaro
 */
import com.proyectoG5.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
        
public interface UsuarioDao extends JpaRepository <Usuario, Long>{
    
    Optional <Usuario> findByCorreoAndContrasena(String correo, String contrasena);
    
    Optional <Usuario> findByCorreo(String correo);

}