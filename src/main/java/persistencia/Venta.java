/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Aaron
 */
@Entity
@Table(name="ventas")
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Date fecha;
    private double total;
    
    @ManyToOne
    @JoinColumn(name="id_empleado")
    private Empleado empleado;
    
    @OneToMany(mappedBy="venta")
    private List<VentaProducto> productosVendidos;

    public Venta() {
    }

    public Venta(Date fecha, double total, Empleado empleado) {
        this.fecha = fecha;
        this.total = total;
        this.empleado = empleado;
    }

    public Venta(Long id, Date fecha, double total, Empleado empleado) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.empleado = empleado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<VentaProducto> getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(List<VentaProducto> productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Venta[ id=" + id + " ]";
    }
    
}
