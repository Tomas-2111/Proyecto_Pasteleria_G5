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

@Data
@Entity
@Table(name="rol")

public class Rol implements Serializable{
    
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_rol")
    private Long id_rol;
    private String nombre;
    
    @OneToMany
    @JoinColumn(name="id_rol")
    List<Usuario> usuarios;
    
    public Rol() {
    }
    
    

    public Rol(String nombre) {
        this.nombre = nombre;
    }


}
