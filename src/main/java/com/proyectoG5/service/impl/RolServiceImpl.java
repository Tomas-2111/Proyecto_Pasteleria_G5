/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proyectoG5.service.impl;

/**
 *
 * @author Tomás Alfaro
 */
import com.proyectoG5.dao.RolDao;
import com.proyectoG5.domain.Rol;
import com.proyectoG5.service.RolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolServiceImpl implements RolService{
    
    @Autowired
    private RolDao rolDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Rol> getRoles(){
        var lista=rolDao.findAll();
        return lista;
    }

}
