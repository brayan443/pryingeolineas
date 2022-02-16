/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingeolineas.modelo;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class Proyecto {
   private int idCodigoProyecto;
   private String nombre;
   private String telefono;
   private Date fecha;
   private String ciudad;
   private String responsable;

    public Proyecto() {
    }

    public Proyecto(int idCodigoProyecto, String nombre, String telefono, Date fecha, String ciudad, String responsable) {
        this.idCodigoProyecto = idCodigoProyecto;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fecha = fecha;
        this.ciudad = ciudad;
        this.responsable = responsable;
    }

    public Proyecto(String nombre, String telefono, Date fecha, String ciudad, String responsable) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.fecha = fecha;
        this.ciudad = ciudad;
        this.responsable = responsable;
    }
    
   

    public int getIdCodigoProyecto() {
        return idCodigoProyecto;
    }

    public void setIdCodigoProyecto(int idCodigoProyecto) {
        this.idCodigoProyecto = idCodigoProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

       
}
