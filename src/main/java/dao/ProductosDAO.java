/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import interfaces.IConexionDB;
import interfaces.IProductosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import objetos.Producto;

/**
 *
 * @author Laboratorios
 */
public class ProductosDAO implements IProductosDAO {
    
    public IConexionDB conexion;
    
    public ProductosDAO(IConexionDB conexion){
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(Producto producto) {
        try {
            Connection c = conexion.crearConexion();
            String insertar = "INSERT INTO producctos (nombre, descripcion, precio) VALUES (?, ?, ?)";
            PreparedStatement i = c.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS);
            i.setString(1, producto.getNombre());
            i.setString(2, producto.getDescripcion());
            i.setDouble(3, producto.getPrecio());
            
            i.executeUpdate();
            
            return true;
        }catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizar(Producto producto) {
        try {
            Connection c = conexion.crearConexion();
            String actualizar = "UPDATE productos SET nombre = ?, descripcion = ?, precio = ? WHERE id = ?";
            PreparedStatement a = c.prepareStatement(actualizar, Statement.RETURN_GENERATED_KEYS);
            a.setString(1, producto.getNombre());
            a.setString(2, producto.getDescripcion());
            a.setDouble(3, producto.getPrecio());
            a.setInt(4, producto.getId());
            
            a.executeUpdate();
            
            return true;
        }catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        try {
            Connection c = conexion.crearConexion();
            String eliminar = "DELETE FROM productos WHERE id = ?";
            PreparedStatement e = c.prepareStatement(eliminar, Statement.RETURN_GENERATED_KEYS);
            e.setInt(1, id);
            
            e.executeUpdate();
            
            return true;
        }catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Producto consultar(int id) {
        try {
            Connection c = conexion.crearConexion();
            String buscarProducto = "SELECT * FROM productos WHERE id = ?";
            PreparedStatement b = c.prepareStatement(buscarProducto);
            b.setInt(1, id);
            
            ResultSet resultado = b.executeQuery();
            
            if(resultado.next()) {
                Producto p = new Producto();
                p.setId(resultado.getInt("id"));
                p.setNombre(resultado.getString("nombre"));
                p.setDescripcion(resultado.getString("descripcion"));
                p.setPrecio(resultado.getDouble("precio"));
                
                return p;
            }else {
                return null;
            }
        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Producto> consultarTodos() {
        try {
            List<Producto> consulta = new ArrayList<Producto>();
            Connection c = conexion.crearConexion();
            String buscarProductos = "SELECT * FROM productos";
            PreparedStatement b = c.prepareStatement(buscarProductos);
            
            ResultSet resultado = b.executeQuery();
            Producto p = new Producto();
            
            while(resultado.next()) {
                p.setId(resultado.getInt("id"));
                p.setNombre(resultado.getString("nombre"));
                p.setDescripcion(resultado.getString("descripcion"));
                p.setPrecio(resultado.getDouble("precio"));
                consulta.add(p);
            }
            
            return consulta;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
}
