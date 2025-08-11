/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proyectoG5.service.impl;

/**
 *
 * @author Tomás Alfaro
 */
import com.proyectoG5.dao.UsuarioDao;
import com.proyectoG5.domain.Usuario;
import com.proyectoG5.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    @Transactional(readOnly=true)
    public Usuario getUsuarioByPass(Usuario usuario)
    {
        return usuarioDao.findByCorreoAndPassword(usuario.getCorreo(),usuario.getPassword()).orElse(null);
        
    }
    
    @Override
    @Transactional(readOnly=true)
    public Usuario getUsuarioByCorreo(Usuario usuario)
    {
        return usuarioDao.findByCorreo(usuario.getCorreo()).orElse(null);
        
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.findByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.existsByUsernameOrCorreo(username, correo);
    }
    
    @Override
    @Transactional()
    public void save(Usuario usuario){
        usuarioDao.save(usuario);
    }
    

}
