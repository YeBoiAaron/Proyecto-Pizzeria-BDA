/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import interfaces.IConexionDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Laboratorios
 */
public class Conexion implements IConexionDB {
    
    private String cadena = "jdbc:mysql://localhost:3306/pizzeria";
    private String usuario = "root";
    private String pass = "admin";

    @Override
    public Connection crearConexion() {
        try{
            Connection c = DriverManager.getConnection(cadena, usuario, pass);
            return c;
        }catch(SQLException e) {
            System.out.println("Hubo un error de conexion");
        }
        
        return null;
    }
    
}
