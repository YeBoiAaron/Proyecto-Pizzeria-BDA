/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.jdbcpizzeria_valenzuelaaaron;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Laboratorios
 */
public class JDBCPizzeria_ValenzuelaAaron {
    
    public static void main(String[] args) {
        String cadenaConexion = "jdbc:mysql://localhost:3306/pizzeria";
        String user = "root";
        String pwd = "itson";
        String i = "INSERT INTO productos (nombre, precio, descripcion) VALUES (?,?,?)";
        String buscarProducto = "SELECT * FROM productos WHERE precio < ?";
        
        try {
            Connection c = DriverManager.getConnection(cadenaConexion, user, pwd);
            
            /*PreparedStatement insert = c.prepareStatement(i, Statement.RETURN_GENERATED_KEYS);
            insert.setString(1, "Pizza de champiñones");
            insert.setDouble(2, 100.0);
            insert.setString(3, "Pizza sencilla con base de tomate y queso, con topping de champiñón.");
            
            insert.executeUpdate();*/
            
            PreparedStatement busqueda = c.prepareStatement(buscarProducto);
            busqueda.setDouble(1, 100);
            
            ResultSet resultados = busqueda.executeQuery();
            
            if(resultados.next()) {
                String nombre = resultados.getString("nombre");
                double precio = resultados.getDouble("precio");
                String descripcion = resultados.getString("descripcion");
                
                System.out.println(nombre + " " + precio + "\n" + descripcion);
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
