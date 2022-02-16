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
import ingeolineas.vista.FrmProyecto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControladorProyecto implements ActionListener{
    
    private FrmProyecto fproyecto;
    private Proyecto proyec;
    private ProyectoDAO proyecD;

    public ControladorProyecto(FrmProyecto fproyecto, Proyecto proyec, ProyectoDAO proyecD) {
        this.fproyecto = fproyecto;
        this.proyec = proyec;
        this.proyecD = proyecD;
        
        this.fproyecto.jBtNuevo.addActionListener(this);
        this.fproyecto.jBtGuardar.addActionListener(this);
        this.fproyecto.jBtModificar.addActionListener(this);
        this.fproyecto.jBtEliminar.addActionListener(this);
        this.fproyecto.jBtConsultar.addActionListener(this);
        this.fproyecto.jBtSalir.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Nuevo, guardar, modificar, eliminar, consultar y salir
       
        //Método que permite insertar nuevos datos
        if (e.getSource() == fproyecto.jBtNuevo) {
            limpiarControles();
        }
        
        //Método que permite guardar datos en la tabla Proyecto
         if (e.getSource() == fproyecto.jBtGuardar) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = format.format(fproyecto.jDtFecha.getDate());
            java.util.Date fechaN = null;
            try {
                fechaN = format.parse(fecha); //¿¿¿Porqué fechaN?
            } catch (ParseException ex) {
                Logger.getLogger(ControladorProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.Date fechasql = new java.sql.Date(fechaN.getTime());
            System.out.println(fechasql);
            String nombre = fproyecto.jTxNombre.getText();
            String telefono = fproyecto.jTxTelefono.getText();
            String ciudad = fproyecto.jTxCiudad.getText();
            String responsable = fproyecto.jTxResponsable.getText();
            proyec = new Proyecto(nombre, telefono, fechasql, ciudad, responsable);
        if (proyecD.adicionar(proyec)) {
                JOptionPane.showMessageDialog(fproyecto, "El proyecto se registró correctamente");
                limpiarControles();
            } else {
                JOptionPane.showMessageDialog(fproyecto, "El proyecto NO se puedo registrar");
            }       
        }
         
         //Método que permite modificar datos de la tabla Proyecto
        if (e.getSource() == fproyecto.jBtModificar) {
            int codProyecto = Integer.parseInt(fproyecto.jTxIdProyecto.getText());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = format.format(fproyecto.jDtFecha.getDate());
            java.util.Date fechaN = null;
            try {
                fechaN = format.parse(fecha); //¿¿¿Porqué fechaN?
            } catch (ParseException ex) {
                Logger.getLogger(ControladorProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.Date fechasql = new java.sql.Date(fechaN.getTime());
            System.out.println(fechasql);
            String nombre = fproyecto.jTxNombre.getText();
            String telefono = fproyecto.jTxTelefono.getText();
            String ciudad = fproyecto.jTxCiudad.getText();
            String responsable = fproyecto.jTxResponsable.getText();
            proyec = new Proyecto(codProyecto, nombre, telefono, fechasql, ciudad, responsable);
            try {
                if (proyecD.actualizar(proyec)){
                JOptionPane.showMessageDialog(fproyecto, "El proyecto se actualizó adecuadamente");
                    limpiarControles();
                } else {
                    JOptionPane.showMessageDialog(fproyecto, "El Proyecto NO se puedo actualizar");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ControladorContratista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Método que permite eliminar datos en la tabla Proyecto
        if (e.getSource() == fproyecto.jBtEliminar) {
           int codProyecto = Integer.parseInt(fproyecto.jTxIdProyecto.getText());
            int respuesta = JOptionPane.showConfirmDialog(fproyecto, "¿Esta seguro de eliminar el registro", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                if (proyecD.eliminar(codProyecto)){
                    JOptionPane.showMessageDialog(fproyecto, "Se eliminó con éxito");
                    limpiarControles();
                } else {
                    JOptionPane.showMessageDialog(fproyecto, "No se eliminó - Verificar datos");
                }
            }
        }
        
       //Método que permite consultar datos de la tabla Contratista
        if (e.getSource() == fproyecto.jBtConsultar) {
            int codProyecto = Integer.parseInt(JOptionPane.showInputDialog(fproyecto, "Código del proyecto a consultar"));
            try {
                proyec = proyecD.consultarProyecto(codProyecto); 
            } catch (SQLException ex) {
                Logger.getLogger(ControladorProyecto.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
            if (proyec != null) {
                fproyecto.jTxIdProyecto.setText(String.valueOf(proyec.getIdCodigoProyecto()));
                fproyecto.jTxNombre.setText(proyec.getNombre());
                fproyecto.jTxTelefono.setText(proyec.getTelefono());
                fproyecto.jDtFecha.setDate(proyec.getFecha());
                fproyecto.jTxCiudad.setText(proyec.getCiudad());
                fproyecto.jTxResponsable.setText(String.valueOf(proyec.getResponsable()));
            } else {
                JOptionPane.showMessageDialog(fproyecto, "El contrato consultado no se encuentra en la Base de Datos");
            }
        }
        
        //Método que permite salir del formulario
        if (e.getSource() == fproyecto.jBtSalir) {
            int respuesta = JOptionPane.showConfirmDialog(fproyecto, "¿Está seguro que desea salir?", "Fin productos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                fproyecto.dispose();
            }
        }
    }
        
        public void limpiarControles() {
        java.util.Date date = new java.sql.Date(new java.util.Date().getTime());
        fproyecto.jTxIdProyecto.setText("");
        fproyecto.jTxNombre.setText("");
        fproyecto.jTxTelefono.setText("");
        fproyecto.jDtFecha.setDate(date);
        fproyecto.jTxCiudad.setText("");
        fproyecto.jTxResponsable.setText("");
        
    }

    }
    

