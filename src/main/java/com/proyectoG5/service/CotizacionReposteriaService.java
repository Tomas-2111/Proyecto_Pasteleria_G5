/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.proyectoG5.service;

/**
 *
 * @author Tomás Alfaro
 */
import com.proyectoG5.domain.CotizacionReposteria;
import java.util.List;

public interface CotizacionReposteriaService {
    
    public List<CotizacionReposteria> getCotizacionesReposteria();
    
    public List<CotizacionReposteria> getCotizacionesReposteriaUsuario();
    
    public CotizacionReposteria getCotizacionReposteria(CotizacionReposteria cotizacionReposteria);
    
    public void save(CotizacionReposteria cotizacionReposteria);

}
