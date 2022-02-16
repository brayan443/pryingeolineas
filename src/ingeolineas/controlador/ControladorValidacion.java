/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingeolineas.controlador;

import ingeolineas.modelo.Usuario;
import ingeolineas.modelo.UsuarioDAO;
import ingeolineas.vista.FrmMenu;
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
public class ControladorValidacion implements ActionListener {

    private FrmValidacion fvalida;
    private UsuarioDAO userD;
    private Usuario user;

    public ControladorValidacion(FrmValidacion fvalida, UsuarioDAO userD, Usuario user) {
        this.fvalida = fvalida;
        this.userD = userD;
        this.user = user;
        this.fvalida.jBtAceptar.addActionListener(this);
        this.fvalida.jBtSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fvalida.jBtAceptar) {
            String usu = fvalida.jTxUsuario.getText();
            String pass = new String(fvalida.jPsContrasenia.getPassword());
            try {
                if (userD.validarUsuario(usu, pass)) {
                    FrmMenu fmenu = new FrmMenu();
                    fmenu.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(fvalida, "Usuario y/o  contraseña incorrectos");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorValidacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //Método que permite salir
        if (e.getSource() == fvalida.jBtSalir) {
            int respuesta = JOptionPane.showConfirmDialog(fvalida, "¿Estas seguro de salir?", "Fin Producto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (respuesta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
}
