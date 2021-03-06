/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingeolineas.vista;

import ingeolineas.controlador.ControladorUsuario;
import ingeolineas.controlador.ControladorValidacion;
import ingeolineas.modelo.Usuario;
import ingeolineas.modelo.UsuarioDAO;

/**
 *
 * @author Usuario
 */
public class FrmValidacion extends javax.swing.JFrame {

    /**
     * Creates new form FrmValidacion
     */
    public FrmValidacion() {
        initComponents();
        this.setLocationRelativeTo(null);
        validar();
    }

    public void validar() {
       if(jTxUsuario.getText().isEmpty()) {
            jLbUsuario.setText("*Campo Usuario requerido");

        }else if(jTxUsuario.getText().length() > 10) {
            jLbUsuario.setText("*Máximo 10 caracteres");
        }else{
            jLbUsuario.setText("");
        }
        if(jPsContrasenia.getText().isEmpty()) {
            jLbContrasena.setText("*Campo Usuario requerido");
        }else if(jPsContrasenia.getText().length() > 10) {
            jLbContrasena.setText("*Máximo 10 caracteres");
        }else{
            jLbContrasena.setText("");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLbUsuarios = new javax.swing.JLabel();
        jLbContrasenia = new javax.swing.JLabel();
        jTxUsuario = new javax.swing.JTextField();
        jPsContrasenia = new javax.swing.JPasswordField();
        jBtAceptar = new javax.swing.JButton();
        jBtSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLbUsuario = new javax.swing.JLabel();
        jLbContrasena = new javax.swing.JLabel();
        jBtFormularioRegistrarse = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLbUsuarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLbUsuarios.setText("Usuario");

        jLbContrasenia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLbContrasenia.setText("Contraseña");

        jTxUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxUsuarioActionPerformed(evt);
            }
        });
        jTxUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxUsuarioKeyReleased(evt);
            }
        });

        jPsContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPsContraseniaActionPerformed(evt);
            }
        });
        jPsContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPsContraseniaKeyReleased(evt);
            }
        });

        jBtAceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBtAceptar.setText("Aceptar");

        jBtSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBtSalir.setText("Salir");
        jBtSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalirActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        jLabel3.setText("Validación Usuario");

        jLbUsuario.setForeground(new java.awt.Color(255, 0, 0));

        jLbContrasena.setForeground(new java.awt.Color(255, 0, 0));

        jBtFormularioRegistrarse.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBtFormularioRegistrarse.setText("Registrarse");
        jBtFormularioRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFormularioRegistrarseActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Ingeolineas S.A.S");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLbUsuarios)
                            .addComponent(jLbContrasenia))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPsContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLbUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(jLbContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jBtAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtSalir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jBtFormularioRegistrarse))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jLabel4)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbUsuarios)
                    .addComponent(jTxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPsContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLbContrasenia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLbContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtAceptar)
                    .addComponent(jBtSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jBtFormularioRegistrarse)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPsContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPsContraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPsContraseniaActionPerformed

    private void jBtSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtSalirActionPerformed

    private void jTxUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxUsuarioKeyReleased
        validar();

    }//GEN-LAST:event_jTxUsuarioKeyReleased

    private void jPsContraseniaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPsContraseniaKeyReleased
        validar();
    }//GEN-LAST:event_jPsContraseniaKeyReleased

    private void jTxUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxUsuarioActionPerformed

    private void jBtFormularioRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFormularioRegistrarseActionPerformed
        
/*Instanciar un objeto de la clase formulario Usuario (Registro) para que me lleve 
al formulario De registro (FrmUsuarioos)*/ 
        Usuario user= new Usuario();
        UsuarioDAO userD = new UsuarioDAO();
        FrmUsuarios fuser = new FrmUsuarios();
        ControladorUsuario contrauser = new ControladorUsuario(fuser,userD,user);
        fuser.setVisible(true);
        this.dispose();
               
        /*FrmUsuarios verFormularioRegistro = new FrmUsuarios();
        verFormularioRegistro.setVisible(true);
        this.dispose();*/
        
       
        
        
    }//GEN-LAST:event_jBtFormularioRegistrarseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmValidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmValidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmValidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmValidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmValidacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBtAceptar;
    public javax.swing.JButton jBtFormularioRegistrarse;
    public javax.swing.JButton jBtSalir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLbContrasena;
    private javax.swing.JLabel jLbContrasenia;
    private javax.swing.JLabel jLbUsuario;
    public javax.swing.JLabel jLbUsuarios;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPasswordField jPsContrasenia;
    public javax.swing.JTextField jTxUsuario;
    // End of variables declaration//GEN-END:variables
}
