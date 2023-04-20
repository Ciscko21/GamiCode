/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gami.gamicodigo.dao;

import com.gami.gamicodigo.model.Usuario;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public interface UsuarioDao extends CRUD<Usuario>{

    public Usuario validar(Usuario usu);

    public void estadoUsuario(Usuario usu);
    
    public Usuario listByUsername(String username) throws SQLException;

}
