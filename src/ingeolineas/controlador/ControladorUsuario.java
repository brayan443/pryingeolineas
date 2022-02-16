/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingeolineas.controlador;

import ingeolineas.modelo.Usuario;
import ingeolineas.modelo.UsuarioDAO;
import ingeolineas.vista.FrmMenu;
import ingeolineas.vista.FrmUsuarios;
import ingeolineas.vista.FrmValidacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControladorUsuario implements ActionListener {

    private FrmUsuarios fuser;
    private UsuarioDAO userD;
    private Usuario user;

    public ControladorUsuario(FrmUsuarios fuser, UsuarioDAO userD, Usuario user) {
        this.fuser = fuser;
        this.userD = userD;
        this.user = user;
        this.fuser.jBtRegistrarse.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fuser.jBtRegistrarse) {
            String idUsuario = fuser.jTxIdUsuario.getText();
            String nomUsuario = fuser.jTxNombreUsuario.getText();
            String usuario = fuser.jTxUsuario.getText();
            String contrasenia = new String(fuser.jPsContrasenia.getPassword());
            String correo = fuser.jTxCorreo.getText();
            user = new Usuario(idUsuario, nomUsuario, usuario, contrasenia, correo);
            if (userD.adicionar(user)) {
                JOptionPane.showMessageDialog(fuser, "El Usuario se registró adecuadamente");
                
            } else {
                JOptionPane.showMessageDialog(fuser, "El Usuario NO se pudo registrar");
            }
        }   
    }
}
