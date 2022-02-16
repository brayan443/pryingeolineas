/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingeolineas.modelo;

/**
 *
 * @author Usuario
 */
public class Contratista {
    private String idCedula;
    private int idCodigoProyecto;
    private String nombre;
    private String apellido;
    private String cargo;
    private String direccion;
    private String telefono;
    private String ciudad;

    public Contratista() {
    }

    public Contratista(String idCedula, int idCodigoProyecto, String nombre, String apellido, String cargo, String direccion, String telefono, String ciudad) {
        this.idCedula = idCedula;
        this.idCodigoProyecto = idCodigoProyecto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

    public String getIdCedula() {
        return idCedula;
    }

    public void setIdCedula(String idCedula) {
        this.idCedula = idCedula;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

   
}
