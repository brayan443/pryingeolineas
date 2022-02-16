/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingeolineas.controlador;

import ingeolineas.modelo.Contratista;
import ingeolineas.modelo.ContratistaDAO;
import ingeolineas.modelo.Proyecto;
import ingeolineas.modelo.ProyectoDAO;
import ingeolineas.vista.FrmContratista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
//Declarar el objeto de las clases FrmContratista, Contratista, ContratistaDAO.
public class ControladorContratista implements ActionListener{
    private FrmContratista fcontra;
    private Contratista contra;
    private ContratistaDAO contraD;

    
    public ControladorContratista(FrmContratista fcontra, Contratista contra, ContratistaDAO contraD) throws SQLException {
        this.fcontra = fcontra;
        this.contra = contra;
        this.contraD = contraD;

        this.fcontra.jCbCodigoProyecto.addActionListener(this);
        this.fcontra.jBtConsultar.addActionListener(this);
        this.fcontra.jBtEliminar.addActionListener(this);
        this.fcontra.jBtGuardar.addActionListener(this);
        this.fcontra.jBtModificar.addActionListener(this);
        this.fcontra.jBtNuevo.addActionListener(this);
        this.fcontra.jBtSalir.addActionListener(this);
        mostrarProyecto();
    }
    
    //Método que permite mostrar varios proyectos
    public void mostrarProyecto() throws SQLException {
        Proyecto proyec = new Proyecto();
        ProyectoDAO proyecDao = new ProyectoDAO();
        ArrayList proyecA = (ArrayList) proyecDao.consultarProyectos();
        for (int i = 0; i < proyecA.size(); i++) {
            proyec = (Proyecto) proyecA.get(i);
            fcontra.jCbCodigoProyecto.addItem(String.valueOf(proyec.getIdCodigoProyecto()));
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == fcontra.jCbCodigoProyecto) {
            int codProyec = Integer.parseInt(fcontra.jCbCodigoProyecto.getSelectedItem().toString());
            Proyecto proyec = new Proyecto();
            ProyectoDAO proyecD = new ProyectoDAO();
            try {
                proyec = proyecD.consultarProyecto(codProyec);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorContratista.class.getName()).log(Level.SEVERE, null, ex);
            }
            fcontra.jTxCodigoProyecto.setText(proyec.getNombre());      
        }
       
       //Nuevo, guardar, modificar, eliminar, consultar y salir
       
        //Método que permite insertar nuevos datos
        if (e.getSource() == fcontra.jBtNuevo) {
            limpiarControles();
        }
        
        //Método que permite guardar datos en la tabla Contratista
         if (e.getSource() == fcontra.jBtGuardar) {
            String cedContratista = fcontra.jTxCedula.getText();
            int codProyecto =Integer.parseInt( fcontra.jCbCodigoProyecto.getSelectedItem().toString());
            String nombre = fcontra.jTxNombres.getText();
            String apellido = fcontra.jTxApellidos.getText();
            String cargo = fcontra.jTxCargo.getText();
            String direccion = fcontra.jTxDireccion.getText();
            String telefono = fcontra.jTxTelefono.getText();
            String ciudad = fcontra.jTxCiudad.getText();
            contra = new Contratista (cedContratista, codProyecto, nombre, apellido, cargo, direccion, telefono, ciudad);
        if (contraD.adicionar(contra)) {
                JOptionPane.showMessageDialog(fcontra, "El contratista se registró correctamente");
                limpiarControles();
            } else {
                JOptionPane.showMessageDialog(fcontra, "El contratista NO se pudo registrar");
            }
        }
         
         
         //Método que permite modificar datos de la tabla Contratistas
          if (e.getSource() == fcontra.jBtModificar) {
            String cedula = fcontra.jTxCedula.getText();
            int codProyecto =Integer.parseInt( fcontra.jCbCodigoProyecto.getSelectedItem().toString());
            String nombre = fcontra.jTxNombres.getText();
            String apellidos = fcontra.jTxApellidos.getText();
            String cargo = fcontra.jTxCargo.getText();
            String direccion = fcontra.jTxDireccion.getText();
            String telefono = fcontra.jTxTelefono.getText();
            String ciudad = fcontra.jTxCiudad.getText();
            contra = new Contratista(cedula, codProyecto, nombre, apellidos, cargo, direccion, telefono, ciudad);
            try {
                if (contraD.actualizar(contra)){
                JOptionPane.showMessageDialog(fcontra, "El contratista se actualizó adecuadamente");
                    limpiarControles();
                } else {
                    JOptionPane.showMessageDialog(fcontra, "El Contratista NO se puedo actualizar");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ControladorContratista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Método que permite eliminar datos en la tabla Contratista
        if (e.getSource() == fcontra.jBtEliminar) {
            String cedContratista = (fcontra.jTxCedula.getText());
            int respuesta = JOptionPane.showConfirmDialog(fcontra, "¿Esta seguro de eliminar el registro", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                if (contraD.eliminar(cedContratista)){
                    JOptionPane.showMessageDialog(fcontra, "Se eliminó con éxito");
                    limpiarControles();
                } else {
                    JOptionPane.showMessageDialog(fcontra, "No se eliminó - Verificar datos");
                }
            }
        }
        
       //Método que permite consultar datos de la tabla Contratista
        if (e.getSource() == fcontra.jBtConsultar) {
            String cedContratista = JOptionPane.showInputDialog(fcontra, "Cedula del contratista a consultar");
            try {
                contra = contraD.consultarContratista(cedContratista);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorContratista.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
            if (contra != null) {
                fcontra.jTxCedula.setText(contra.getIdCedula());
                fcontra.jCbCodigoProyecto.setSelectedItem(String.valueOf(contra.getIdCodigoProyecto()));
                fcontra.jTxNombres.setText(contra.getNombre());
                fcontra.jTxApellidos.setText(contra.getApellido());
                fcontra.jTxCargo.setText(contra.getCargo());
                fcontra.jTxDireccion.setText(contra.getDireccion());
                fcontra.jTxTelefono.setText(contra.getTelefono());
                fcontra.jTxCiudad.setText(contra.getCiudad());
            } else {
                JOptionPane.showMessageDialog(fcontra, "El contratista consultado no se encuentra en la BD");
            }
        }
        
        //Método que permite salir del formulario
        if (e.getSource() == fcontra.jBtSalir) {
            int respuesta = JOptionPane.showConfirmDialog(fcontra, "¿Está seguro que desea salir?", "Fin productos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                fcontra.dispose();
            }
        }
    }
        
        public void limpiarControles() {
        java.util.Date date = new java.sql.Date(new java.util.Date().getTime());
        fcontra.jTxCedula.setText("");
        fcontra.jTxCodigoProyecto.setText("");
        fcontra.jTxNombres.setText("");
        fcontra.jTxApellidos.setText("");
        fcontra.jTxCargo.setText("");
        fcontra.jTxDireccion.setText("");
        fcontra.jTxTelefono.setText("");
        fcontra.jTxCiudad.setText("");
    }

    }

