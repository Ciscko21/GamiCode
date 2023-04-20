/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.gami.gamicodigo.controladores;

import com.gami.gamicodigo.daoImpl.UsuarioDaoImpl;
import com.gami.gamicodigo.model.Usuario;
import java.io.IOException;
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
public class ControladorLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        HttpSession session = request.getSession();

        if (action.equals("iniciarSesion")) {

            try {
                String usuario = request.getParameter("username");

                Usuario usu = new Usuario();

                UsuarioDaoImpl dao = new UsuarioDaoImpl();

                usu = dao.listByUsername(usuario);

                if (usu != null) {

                    usu.setActive(Boolean.TRUE);

                    dao.edit(usu);

                    usu = dao.listByUsername(usuario);

                    session.setAttribute("usuario", usu);
                    session.setMaxInactiveInterval(30 * 60);

                    response.sendRedirect("inicio.jsp");

                } else {

                    response.sendRedirect("index.html");

                    System.out.println("Error Login: ");

                }

            } catch (SQLException ex) {

                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
