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
import com.proyectoG5.domain.Usuario;

@Data
@Entity
@Table(name="cotizacion_reposteria")

public class CotizacionReposteria implements Serializable{
    
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    
    private Long id;
    private String tipo_reposteria;
    private int cantidad;
    private String descripcion;
    private String estado;
    
    public CotizacionReposteria(){
        
    }
    

}
