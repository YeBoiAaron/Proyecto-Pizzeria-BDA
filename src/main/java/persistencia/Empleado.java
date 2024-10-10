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
@Table(name="empleados")
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private Date fecha_nac;
    private String puesto;
    private Long num_telefono;
    
    @OneToMany(mappedBy="empleado", cascade=CascadeType.PERSIST)
    private List<Venta> ventas;

    public Empleado() {
    }

    public Empleado(String nombre, Date fecha_nac, String puesto, Long num_telefono) {
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.puesto = puesto;
        this.num_telefono = num_telefono;
    }

    public Empleado(Long id, String nombre, Date fecha_nac, String puesto, Long num_telefono) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.puesto = puesto;
        this.num_telefono = num_telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Long getNum_telefono() {
        return num_telefono;
    }

    public void setNum_telefono(Long num_telefono) {
        this.num_telefono = num_telefono;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
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
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Empleado[ id=" + id + " ]";
    }
    
}
