/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingeolineas.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ProyectoDAO {
  
    //Definir un objeto de la clase conexión

    Conexion cn = new Conexion();
    //Definir un objeto para validar conexción
    Connection con;
    //Verificar las instrucciones de SQL y ejecutarlas
    PreparedStatement ps;
    //Carga el resultado de la consulta con un objeto de la clase
    ResultSet rs;
    //Instanciar la clase proyecto, es decir, crear un objeto de la clase proyecto
    Proyecto proyec = new Proyecto();

    //Método para insertar datos a proyecto en la BD (base de datos)
    public boolean adicionar(Proyecto proyec) {
        String sql = "insert into proyecto(idCodigoProyecto, Nombre, Telefono, fecha, ciudad, Responsable) values (?,?,?,?,?,?)";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, proyec.getIdCodigoProyecto());
            ps.setString(2, proyec.getNombre());
            ps.setString(3, proyec.getTelefono());
            ps.setDate(4, proyec.getFecha());
            ps.setString(5, proyec.getCiudad());
            ps.setString(6, proyec.getResponsable());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
            return false;
        }
        return true;
    }

    //Método que permite consultar un solo Proyecto
    public Proyecto consultarProyecto(int idCodigoProyecto) throws SQLException {
        String sql = "Select * from proyecto where  idCodigoProyecto='" + idCodigoProyecto + "'";
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        if (rs.next()) {
            proyec.setIdCodigoProyecto(rs.getInt("idCodigoProyecto"));
            proyec.setNombre(rs.getString("Nombre"));
            proyec.setTelefono(rs.getString("Telefono"));
            proyec.setFecha(rs.getDate("Fecha"));
            proyec.setCiudad(rs.getString("Ciudad"));
            proyec.setResponsable(rs.getString("Responsable"));            
            return proyec;
        } else {
            return null;
        }
        //(idCodigoProyecto, idCodigoSG, Nombre, Telefono, fecha, ciudad, Responsable) 
    }
    
    //Método que permite consultar todos los Proyectos
    public ArrayList consultarProyectos() throws SQLException {
        String sql = "Select * from proyecto";
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        ArrayList listProyec = new ArrayList();
        while (rs.next()) {
            proyec.setIdCodigoProyecto(rs.getInt("idCodigoProyecto"));
            proyec.setNombre(rs.getString("Nombre"));
            proyec.setTelefono(rs.getString("Telefono"));
            proyec.setFecha(rs.getDate("Fecha"));
            proyec.setCiudad(rs.getString("Ciudad"));
            proyec.setResponsable(rs.getString("Responsable"));
            listProyec.add(new Proyecto(proyec.getIdCodigoProyecto(), proyec.getNombre(), proyec.getTelefono(), proyec.getFecha(),
                    proyec.getCiudad(), proyec.getResponsable()));
                    
        }
        return listProyec;
    }

    //Método para actualizar datos a Proyecto en BD
    public boolean actualizar(Proyecto proyec) throws SQLException {
        String sql = "update proyecto set Nombre=?, Telefono=?, fecha=?, Ciudad=?, Responsable=? where idCodigoProyecto=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, proyec.getNombre());
            ps.setString(2, proyec.getTelefono());
            ps.setDate(3, proyec.getFecha());
            ps.setString(4, proyec.getCiudad());
            ps.setString(5, proyec.getResponsable());
            ps.setInt(6, proyec.getIdCodigoProyecto());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
            return false;
        }
        return true;
        
    }
    
    //Método que permite eliminar datos
    public boolean eliminar(int idCodigoProyecto) {
        String sql = "Delete from proyecto where idCodigoProyecto=" + idCodigoProyecto;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
            return false;
        }
        return true;
    }

}
