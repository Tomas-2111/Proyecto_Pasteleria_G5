/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.proyectoG5.dao;


/**
 *
 * @author Tomás Alfaro
 */

import com.proyectoG5.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
        
public interface RolDao extends JpaRepository <Rol, Long>{

}
