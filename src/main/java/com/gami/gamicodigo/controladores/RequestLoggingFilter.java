/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package com.gami.gamicodigo.controladores;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import jakarta.servlet.Filter;

/**
 *
 * @author usuario
 */
public class RequestLoggingFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        Enumeration<String> params = req.getParameterNames();

        System.out.println("----------------FILTER REQUEST LOGIN-----------------");

        while (params.hasMoreElements()) {

            String name = params.nextElement();

            String value = request.getParameter(name);

            System.out.println(req.getRemoteAddr() + "::Request Params::{" + name + "=" + value + "}");

        }
        
        System.out.println("Authorized access loginControlador ");
        
        System.out.println("------------------------------------------------------");
        
        chain.doFilter(request, response);

    }

    public void destroy() {
        //we can close resources here
    }

}
