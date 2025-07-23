/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proyectoG5.service.impl;

/**
 *
 * @author Tomás Alfaro
 */
import com.proyectoG5.dao.CotizacionReposteriaDao;
import com.proyectoG5.domain.CotizacionReposteria;
import com.proyectoG5.service.CotizacionReposteriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CotizacionReposteriaServiceImpl implements CotizacionReposteriaService{
    
    @Autowired
    private CotizacionReposteriaDao cotizacionReposteriaDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<CotizacionReposteria> getCotizacionesReposteria(){
        var lista= cotizacionReposteriaDao.findAll();
        
        lista.removeIf(e -> e.getEstado()=="Finalizada");
        
        return lista;
        
    }
    
    

}
