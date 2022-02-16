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
public class ContratistaDAO {
    //Definir un objeto de la clase conexión

    Conexion cn = new Conexion();
    //Definir un objeto para validar conexción
    Connection con;
    //Verificar las instrucciones de SQL y ejecutarlas
    PreparedStatement ps;
    //Carga el resultado de la consulta con un objeto de la clase
    ResultSet rs;
    //Instanciar la clase contratista, es decir, crear un objeto de la clase contratista
    Contratista contra = new Contratista();

    //Método para insertar datos a contratista en la BD (base de datos)
    public boolean adicionar(Contratista contra) {
        String sql = "insert into contratista(idCedula, idCodigoProyecto, Nombre, Apellido, Cargo, Direccion, Telefono, Ciudad) values (?,?,?,?,?,?,?,?)";
        con = cn.getConnection(); //
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, contra.getIdCedula());
            ps.setInt(2, contra.getIdCodigoProyecto());
            ps.setString(3, contra.getNombre());
            ps.setString(4, contra.getApellido());
            ps.setString(5, contra.getCargo());
            ps.setString(6, contra.getDireccion());
            ps.setString(7, contra.getTelefono());
            ps.setString(8, contra.getCiudad());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
            return false;
        }
        return true;
    }

    //Método que permite consultar un solo Contratista
    public Contratista consultarContratista(String idCedula) throws SQLException {
        String sql = "Select * from contratista where  idCedula='" + idCedula + "'";
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        if (rs.next()) {
            contra.setIdCedula(rs.getString("idCedula"));
            contra.setIdCodigoProyecto(rs.getInt("idCodigoProyecto"));
            contra.setNombre(rs.getString("Nombre"));
            contra.setApellido(rs.getString("Apellido"));
            contra.setCargo(rs.getString("Cargo"));
            contra.setDireccion(rs.getString("Direccion"));
            contra.setTelefono(rs.getString("Telefono"));
            contra.setCiudad(rs.getString("Ciudad"));
            
            return contra;
        } else {
            return null;
        }
        //(idCodigoCedula, idCodigoProyecto, idCodigoEpp, idCodigoSg, Nombre, 
        //Apellido, Cargo, Direccion, Telefono, Ciudad)
    }
    
    //Método que permite consultar todos Contratistas
    public ArrayList consultarContratistas() throws SQLException {
        String sql = "Select * from contratista";
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        ArrayList listContra = new ArrayList();
        while (rs.next()) {
            contra.setIdCedula(rs.getString("idCedula"));
            contra.setIdCodigoProyecto(rs.getInt("idCodigoProyecto"));
            contra.setNombre(rs.getString("Nombre"));
            contra.setApellido(rs.getString("Apellido"));
            contra.setCargo(rs.getString("Cargo"));
            contra.setDireccion(rs.getString("Direccion"));
            contra.setTelefono(rs.getString("Telefono"));
            contra.setCiudad(rs.getString("Ciudad"));
            listContra.add(new Contratista(contra.getIdCedula(), contra.getIdCodigoProyecto(), contra.getNombre(), 
                    contra.getApellido(), contra.getCargo(), contra.getDireccion(), contra.getTelefono(), contra.getCiudad()));
                    
        }
        return listContra;
    }
    

    //Método para actualizar datos a contratista en BD
    public boolean actualizar(Contratista contra) throws SQLException {
        String sql = "update contratista set idCodigoProyecto=?, "
                + "Nombre=?, Apellido=?, Cargo=?, Direccion=?,"
                + "Telefono=?, Ciudad=? where idCedula=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, contra.getIdCodigoProyecto());
            ps.setString(2, contra.getNombre());
            ps.setString(3, contra.getApellido());
            ps.setString(4, contra.getCargo());
            ps.setString(5, contra.getDireccion());
            ps.setString(6, contra.getTelefono());
            ps.setString(7, contra.getCiudad()); 
             ps.setString(8, contra.getIdCedula());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
            return false;
        }
        return true;
        
    }
    
    //Método que permite eliminar datos
    public boolean eliminar(String idCedula) {
        String sql = "Delete from contratista where idCedula=" + idCedula;
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
