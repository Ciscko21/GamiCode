/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gami.gamicodigo.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface CRUD<T> {

    public List<T> listar();

    public T list(int id);

    public boolean add(T t);

    public void edit(T t) throws SQLException;

    public boolean delete(int id);

}
