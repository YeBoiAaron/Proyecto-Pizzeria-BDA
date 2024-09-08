/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import objetos.Producto;

/**
 *
 * @author Aaron
 */
public class Conversion {
    private String nombresColumnasTabla[] = {"ID", "Nombre", "Descripción", "Precio"};
    
    public DefaultTableModel productosTableModel(List<Producto> listaProductos) {
        DefaultTableModel model;
        Object tabla[][];
        
        if(listaProductos != null) {
            tabla = new Object[listaProductos.size()][4];
            for(int i = 0; i < listaProductos.size(); i++) {
                Producto producto = listaProductos.get(i);
                tabla[i][0] = producto.getId();
                tabla[i][1] = producto.getNombre();
                tabla[i][2] = producto.getDescripcion();
                tabla[i][3] = producto.getPrecio();
            }
            
            model = new DefaultTableModel(tabla, nombresColumnasTabla);
            return model;
        }
        
        return null;
    }
}
