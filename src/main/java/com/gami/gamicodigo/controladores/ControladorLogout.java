/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.gami.gamicodigo.controladores;

import com.gami.gamicodigo.daoImpl.UsuarioDaoImpl;
import com.gami.gamicodigo.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class ControladorLogout extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        HttpSession session = request.getSession(false);

        Usuario usu = new Usuario();

        UsuarioDaoImpl dao = new UsuarioDaoImpl();

        usu = (Usuario) session.getAttribute("usuario");

        usu.setActive(Boolean.FALSE);

        try {
            dao.edit(usu);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorLogout.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("User=" + session.getAttribute("usuario")+session.getId());
        
        if (session != null) {
            session.invalidate();
        }

        //session.removeAttribute("usuario");
        response.sendRedirect("index.html");
    }

}
