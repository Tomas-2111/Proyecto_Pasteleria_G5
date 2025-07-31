/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proyectoG5.service.impl;

/**
 *
 * @author Tomás Alfaro
 */
import com.proyectoG5.dao.CotizacionPastelDao;
import com.proyectoG5.domain.CotizacionPastel;
import com.proyectoG5.service.CotizacionPastelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CotizacionPastelServiceImpl implements CotizacionPastelService{
    
    @Autowired
    private CotizacionPastelDao cotizacionPastelDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<CotizacionPastel> getCotizacionesPastel(){
        var lista= cotizacionPastelDao.findAll();
        
        lista.removeIf(e -> e.getEstado().equals("Finalizada"));
        
        return lista;
        
    }
    
    
    @Override
    @Transactional()
    public void save(CotizacionPastel cotizacionPastel){
        cotizacionPastelDao.save(cotizacionPastel);
    }

}
