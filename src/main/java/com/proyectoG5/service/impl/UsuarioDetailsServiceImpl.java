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
import com.proyectoG5.domain.Rol;
import com.proyectoG5.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService,
UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioDetailsServiceImpl.class);
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws
        UsernameNotFoundException {
         //Se busca el usuario que tiene el username pasado por parámetro...
         Usuario usuario = usuarioDao.findByUsername(username);

         //Se valida si se recuperó un usuario / sino lanza un error
         if (usuario==null) {
            logger.info("Error con el usuario {} ", usuario.getUsername());
            throw new UsernameNotFoundException(username);
        }
         
        session.removeAttribute("usuarioActivo");
        session.setAttribute("usuarioActivo", usuario);


    //Se van a recuperar los roles del usuario y se crean los roles ya como seguridad de Spring
    
        var roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));
        logger.info("Roles cargados para el usuario {}: {}, contrasenna: {}", usuario.getUsername(), roles, usuario.getPassword());
        //Se retorna un User (de tipo UserDetails)
        return new User(usuario.getUsername(),usuario.getPassword(),roles);
    }

}
