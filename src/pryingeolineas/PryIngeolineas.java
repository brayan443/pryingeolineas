/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pryingeolineas;

import ingeolineas.controlador.ControladorValidacion;
import ingeolineas.modelo.Usuario;
import ingeolineas.modelo.UsuarioDAO;
import ingeolineas.vista.FrmMenu;
import ingeolineas.vista.FrmValidacion;

/**
 *
 * @author Usuario
 */
public class PryIngeolineas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     /* FrmMenu fmenu = new FrmMenu();
      fmenu.setVisible(true); */
      
      Usuario user= new Usuario();
        UsuarioDAO userD = new UsuarioDAO();
        FrmValidacion fvalida = new FrmValidacion();
        ControladorValidacion contravalida = new ControladorValidacion(fvalida,userD,user);
        fvalida.setVisible(true);
    }
    
}
