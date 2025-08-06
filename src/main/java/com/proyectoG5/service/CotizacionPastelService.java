/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.proyectoG5.service;

/**
 *
 * @author Tomás Alfaro
 */
import com.proyectoG5.domain.CotizacionPastel;
import java.util.List;

public interface CotizacionPastelService {
    
     public List<CotizacionPastel> getCotizacionesPastel();
     
     public CotizacionPastel getCotizacionPastel(CotizacionPastel cotizacionPastel);
     
     public void save(CotizacionPastel cotizacionPastel);

}
