/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gami.gamicodigo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class Conexion {

    protected static Connection con;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/gami?user=root&password=admin&useSSL=false&allowPublicKeyRetrieval=true";

    public static Connection getconexion() {

        con = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url);

        } catch (ClassNotFoundException | SQLException e) {

            System.out.println("error de conexion:" + e);

        }
        return con;
    }

    public static void main(String[] args) {

        Conexion.getconexion();
    }

}
