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
public class ElementoPp {
    private String idCedula;
    private int idCodigoEpp;
    private String nombreEpp;

    public ElementoPp() {
    }

    public ElementoPp(String idCedula, int idCodigoEpp, String nombreEpp) {
        this.idCedula = idCedula;
        this.idCodigoEpp = idCodigoEpp;
        this.nombreEpp = nombreEpp;
    }

     public ElementoPp(String idCedula, String nombreEpp) {
        this.idCedula = idCedula;
        this.nombreEpp = nombreEpp;
    }

    public String getIdCedula() {
        return idCedula;
    }

    public void setIdCedula(String idCedula) {
        this.idCedula = idCedula;
    }

    public int getIdCodigoEpp() {
        return idCodigoEpp;
    }

    public void setIdCodigoEpp(int idCodigoEpp) {
        this.idCodigoEpp = idCodigoEpp;
    }

    public String getNombreEpp() {
        return nombreEpp;
    }

    public void setNombreEpp(String nombreEpp) {
        this.nombreEpp = nombreEpp;
    }

   
}
