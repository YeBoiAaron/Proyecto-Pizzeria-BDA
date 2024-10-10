/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pizzeriajpa;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import persistencia.*;

/**
 *
 * @author Laboratorios
 */
public class PizzeriaJPA {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_pizzeria");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            java.util.GregorianCalendar utilDate = new java.util.GregorianCalendar(2000, 3 - 1, 14);
            Empleado e1 = new Empleado("Andres Lopez", new Date(utilDate.getTimeInMillis()), "Cajero", 6441234567L);
            em.persist(e1);

            Producto pizza = em.find(Producto.class, 2L);
            Ingrediente i1 = em.find(Ingrediente.class, 1L);
            Ingrediente i2 = em.find(Ingrediente.class, 3L);
            List<Ingrediente> ingredientes = new ArrayList();

            ingredientes.add(i1);
            ingredientes.add(i2);
            pizza.setIngredientes(ingredientes);

            Venta venta = new Venta(new Date(System.currentTimeMillis()), 89.99, e1);
            em.persist(venta);

            VentaProducto ventaProducto = new VentaProducto(pizza, venta, 1, 89.99, 89.99);
            em.persist(ventaProducto);

            em.getTransaction().commit();
            System.out.println("Operacion terminada");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            System.out.println("Operacion fallida");
        }
        
        
//        TipoIngrediente tipo = new TipoIngrediente("Refrigerados");
//        List<Ingrediente> ingredientes = new ArrayList();
//        
//        ingredientes.add(new Ingrediente("Salami", 10, tipo));
//        ingredientes.add(new Ingrediente("Queso mozzarella", 50, tipo));
//        ingredientes.add(new Ingrediente("Salsa de tomate", 100, tipo));
//        
//        tipo.setIngredientes(ingredientes);
//        
//        em.getTransaction().begin();
//        em.persist(tipo);
//        em.getTransaction().commit();
//        System.out.println("Operacion Terminada");
//        
//        Producto pizza = em.find(Producto.class, 1L);
//        if(pizza != null){
//        em.getTransaction().begin();
//        Producto pizzaPepperoni = new Producto("Pizza de anchoas", "Pizza de miedo", (float)99.99);
//        em.persist(pizzaPepperoni);
//        em.getTransaction().commit();
//        
//        System.out.println("Pizza guardada");
//
//        em.remove(pizza);
//        em.getTransaction().commit();
//        
//        System.out.println("Pizza eliminada");
//        } else {
//            System.out.println("no existe el producto");
//        }
//        
    }
}
