/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proyectoG5.domain;

/**
 *
 * @author Tomás Alfaro
 */
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import com.proyectoG5.domain.Rol;

@Data
@Entity
@Table(name="usuario")

public class Usuario implements Serializable{
    
     private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_usuario")
    
    private Long idUsuario;
    private String nombre;
    private String correo;
    private String contrasena;
    private int idRol;

    
    public Usuario(){
        
    }
    
    public Usuario(String nombre, String correo, String contrasena){
        this.nombre=nombre;
        this.correo=correo;
        this.contrasena=contrasena;
    
    }

}
