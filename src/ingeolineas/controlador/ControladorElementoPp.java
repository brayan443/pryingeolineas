/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingeolineas.controlador;

import ingeolineas.modelo.Contratista;
import ingeolineas.modelo.ContratistaDAO;
import ingeolineas.modelo.ElementoPp;
import ingeolineas.modelo.ElementoPpDAO;
import ingeolineas.modelo.Proyecto;
import ingeolineas.modelo.ProyectoDAO;
import ingeolineas.vista.FrmElementoPp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControladorElementoPp implements ActionListener{
    private FrmElementoPp felemento;
    private ElementoPp elemento;
    private ElementoPpDAO elementoD;

    public ControladorElementoPp(FrmElementoPp felemento, ElementoPp elemento, ElementoPpDAO elementoD) throws SQLException {
        this.felemento = felemento;
        this.elemento = elemento;
        this.elementoD = elementoD;
        
        this.felemento.jCbIdCedula.addActionListener(this);
        this.felemento.jBtConsultar.addActionListener(this);
        this.felemento.jBtEliminar.addActionListener(this);
        this.felemento.jBtGuardar.addActionListener(this);
        this.felemento.jBtModificar.addActionListener(this);
        this.felemento.jBtNuevo.addActionListener(this);
        this.felemento.jBtSalir.addActionListener(this);
        mostrarContratistas();       
    }
    
    //Método que permite mostrar varios Contratistas
    public void mostrarContratistas() throws SQLException {
        Contratista contra = new Contratista();
        ContratistaDAO contraD = new ContratistaDAO();
        ArrayList contraA = (ArrayList) contraD.consultarContratistas();
        for (int i = 0; i < contraA.size(); i++) {
            contra = (Contratista) contraA.get(i);
            felemento.jCbIdCedula.addItem(String.valueOf(contra.getIdCedula()));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == felemento.jCbIdCedula) {
            String idCedula = felemento.jCbIdCedula.getSelectedItem().toString();
            Contratista contra = new Contratista();
            ContratistaDAO contraD = new ContratistaDAO();
            try {
                contra = contraD.consultarContratista(idCedula);//¿¿¿por qué aquí se llama el método individual y no el que consulta todos????
            } catch (SQLException ex) {
                Logger.getLogger(ControladorContratista.class.getName()).log(Level.SEVERE, null, ex);
            }
            felemento.jTxIdCedula.setText(contra.getNombre());      
        }
       
       //Método que permite insertar nuevos datos
        if (e.getSource() == felemento.jBtNuevo) {
            limpiarControles();
        }
        
        //Método que permite guardar datos en la tabla Contratista
         if (e.getSource() == felemento.jBtGuardar) {
            String idCedula = felemento.jCbIdCedula.getSelectedItem().toString();
            String nombre = felemento.jTxNombreElemento.getText();
            elemento = new ElementoPp (idCedula, nombre);
        if (elementoD.adicionarEpp(elemento)) {
                JOptionPane.showMessageDialog(felemento, "El Elemento de Protección se registró correctamente");
                limpiarControles();
            } else {
                JOptionPane.showMessageDialog(felemento, "El Elemento de Protección NO se pudo registrar");
            }
        }
         
         
         //Método que permite modificar datos de la tabla Contratistas
          if (e.getSource() == felemento.jBtModificar) {
            int codigo = Integer.parseInt(felemento.jTxCodigoEpp.getText());
            String nombre = felemento.jTxNombreElemento.getText();
            String idCedula=felemento.jCbIdCedula.getSelectedItem().toString();
           elemento = new ElementoPp (idCedula, codigo, nombre);
            try {
                if (elementoD.actualizarEpp(elemento)){
                JOptionPane.showMessageDialog(felemento, "El contratista se actualizó adecuadamente");
                limpiarControles();
                } else {
                    JOptionPane.showMessageDialog(felemento, "El Contratista NO se puedo actualizar");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ControladorContratista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Método que permite eliminar datos en la tabla Contratista
        if (e.getSource() == felemento.jBtEliminar) {
            int codElemento = Integer.parseInt(felemento.jTxCodigoEpp.getText());
            int respuesta = JOptionPane.showConfirmDialog(felemento, "¿Esta seguro de eliminar el registro", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                if (elementoD.eliminarEpp(codElemento)){
                    JOptionPane.showMessageDialog(felemento, "Se eliminó con éxito");
                    limpiarControles();
                } else {
                    JOptionPane.showMessageDialog(felemento, "No se eliminó - Verificar datos");
                }
            }
        }
        
       //Método que permite consultar datos de la tabla Contratista
        if (e.getSource() == felemento.jBtConsultar) {
            int codElemento = Integer.parseInt(JOptionPane.showInputDialog(felemento, "Código del Elemento de Protección a consultar"));
            try {
                elemento = elementoD.consultarEpp(codElemento);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorElementoPp.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
            if (elemento != null) {
                felemento.jTxCodigoEpp.setText(String.valueOf(elemento.getIdCodigoEpp()));
                felemento.jTxNombreElemento.setText(elemento.getNombreEpp());
                felemento.jCbIdCedula.setSelectedItem(String.valueOf(elemento.getIdCedula()));
                
            } else {
                JOptionPane.showMessageDialog(felemento, "El contratista consultado no se encuentra en la BD");
            }
        }
        
        //Método que permite salir del formulario
        if (e.getSource() == felemento.jBtSalir) {
            int respuesta = JOptionPane.showConfirmDialog(felemento, "¿Está seguro que desea salir?", "Fin productos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                felemento.dispose();
            }
        }
    }
        
        public void limpiarControles() {
        java.util.Date date = new java.sql.Date(new java.util.Date().getTime());
        felemento.jTxIdCedula.setText("");
        felemento.jTxCodigoEpp.setText("");
        felemento.jTxNombreElemento.setText("");
        
    }
}

    
    
    
    

