/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gami.gamicodigo.daoImpl;

import com.gami.gamicodigo.config.Conexion;
import com.gami.gamicodigo.dao.UsuarioDao;
import com.gami.gamicodigo.model.Perfil;
import com.gami.gamicodigo.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author usuario
 */
public class UsuarioDaoImpl implements UsuarioDao {

    PreparedStatement ps, ps1;
    ResultSet rs, rs1;

    @Override
    public Usuario validar(Usuario usu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void estadoUsuario(Usuario usu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void edit(Usuario t) throws SQLException {

        String sql = "update user set username=?, name=?, last_name=?, active=? where id=?";

        ps = Conexion.getconexion().prepareStatement(sql);

        ps.setString(1, t.getUsername());
        ps.setString(2, t.getName());
        ps.setString(3, t.getLast_Name());
        ps.setBoolean(4, t.getActive());
        ps.setInt(5, t.getId());

        ps.executeUpdate();
        ps.close();
        Conexion.getconexion().close();
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario listByUsername(String username) throws SQLException {

        //-------SE DECLARAN LAS CONSULTAS A UTILIZAR-----
        String traerUsuario = "select * from user where username=?";
        String traerPerfil = "select * from profile where id=?";

        //-------SE TRAE EL USUARIO-----
        ps = Conexion.getconexion().prepareStatement(traerUsuario);
        ps.setString(1, username);
        rs = ps.executeQuery();

        Usuario usu = new Usuario();

        while (rs.next()) {

            usu.setId(rs.getInt("id"));
            usu.setUsername(rs.getString("username"));
            usu.setName(rs.getString("name"));
            usu.setLast_Name(rs.getString("last_name"));
            usu.setActive(rs.getBoolean("active"));
            usu.setProfile_id(rs.getInt("profile_id"));
        }
        
        
        if(usu.getProfile_id()==0){
            return null;
        }
        rs.close();
        ps.close();
        
        
        
        //-------SE TRAE EL PERFIL RELACIONADO AL USUARIO-----
        ps1 = Conexion.getconexion().prepareStatement("select * from profile where id=?");
        ps1.setInt(1, usu.getProfile_id());
        rs1 = ps1.executeQuery();
        
        Perfil pro = new Perfil();
        while (rs1.next()) {

            pro.setId(rs1.getInt("id"));
            pro.setNivel(rs1.getInt("nivel"));
            pro.setTotalPoints(rs1.getInt("total_points"));
            pro.setExamComplete(rs1.getInt("exam_complete"));
        }

        //-------ASIGNAMOS EL PERFIL AL USUARIO-----
        usu.setProfile(pro);

        //-------CERRAMOS CONEXION-----
        rs1.close();
        ps1.close();
        Conexion.getconexion().close();

        //-------RETORNAMOS EL USUARIO-----
        return usu;
    }

}
