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
public class DocumentoSgsst {
    
    private int idCodigoSg;
    private int idCodigoProyecto;
    private String nombre;

    public DocumentoSgsst() {
    }

    public DocumentoSgsst(int idCodigoSg, int idCodigoProyecto, String nombre) {
        this.idCodigoSg = idCodigoSg;
        this.idCodigoProyecto = idCodigoProyecto;
        this.nombre = nombre;
    }
    
     public DocumentoSgsst(int idCodigoProyecto, String nombre) {
        this.idCodigoProyecto = idCodigoProyecto;
        this.nombre = nombre;
    }

    public int getIdCodigoSg() {
        return idCodigoSg;
    }

    public void setIdCodigoSg(int idCodigoSg) {
        this.idCodigoSg = idCodigoSg;
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
   
     
    
}
