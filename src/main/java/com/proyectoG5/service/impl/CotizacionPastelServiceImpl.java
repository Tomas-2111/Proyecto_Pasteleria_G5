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
import com.proyectoG5.domain.Usuario;
import com.proyectoG5.service.CotizacionPastelService;
import com.proyectoG5.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


@Service
public class CotizacionPastelServiceImpl implements CotizacionPastelService{
    
    @Autowired
    private CotizacionPastelDao cotizacionPastelDao;
    @Autowired
    private UsuarioService usuarioService;
    
    @Override
    @Transactional(readOnly=true)
    public List<CotizacionPastel> getCotizacionesPastel(){
        var lista= cotizacionPastelDao.findAll();
        
        lista.removeIf(e -> e.getEstado().equals("Finalizada"));
        
        return lista;
        
    }
    
     @Override
    @Transactional(readOnly=true)
    public List<CotizacionPastel> getCotizacionesPastelUsuario(){
        var lista= cotizacionPastelDao.findAll();
        //Se obtiene el usuario autenticado
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }

        if (username.isBlank()) {
            return null;
        }

        Usuario usuario = usuarioService.getUsuarioPorUsername(username);

        if (usuario == null) {
            return null;
        }
        
        lista.removeIf(e -> (e.getUsuario().getIdUsuario()!=usuario.getIdUsuario()));
                
         
        
        return lista;
        
    }
    
    
    @Override
    @Transactional()
    public void save(CotizacionPastel cotizacionPastel){
        //Se obtiene el usuario autenticado
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }

        if (username.isBlank()) {
            return;
        }

        Usuario usuario = usuarioService.getUsuarioPorUsername(username);

        if (usuario == null) {
            return;
        }
        if(cotizacionPastel.getId()==null){
           cotizacionPastel.setUsuario(usuario);
        }
     
        cotizacionPastelDao.save(cotizacionPastel);
    }
    
    
    @Override
    @Transactional(readOnly=true)
    public CotizacionPastel getCotizacionPastel(CotizacionPastel cotizacionPastel){
        return cotizacionPastelDao.findById(cotizacionPastel.getId()).orElse(null);
    }

}
