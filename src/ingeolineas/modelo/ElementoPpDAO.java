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

/**
 *
 * @author Usuario
 */
public class ElementoPpDAO {
    
    //Definir un objeto de la clase conexión

    Conexion cn = new Conexion();
    //Definir un objeto para validar conexción
    Connection con;
    //Verificar las instrucciones de SQL y ejecutarlas
    PreparedStatement ps;
    //Carga el resultado de la consulta con un objeto de la clase
    ResultSet rs;
    //Instanciar la clase ElementoPp, es decir, crear un objeto de la clase ElementoPp
    ElementoPp epp = new ElementoPp();

    //Método para insertar datos a ElementoPp en la BD (base de datos)
    public boolean adicionarEpp(ElementoPp epp) {
        String sql = "insert into epp (nombre, idCedula) values (?,?)";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, epp.getNombreEpp());
            ps.setString(2, epp.getIdCedula());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
            return false;
        }
        return true;
    }

    //Método que permite consultar un solo EPP
    public ElementoPp consultarEpp(int idCodigoEpp) throws SQLException {
        String sql = "Select * from epp where  idCodigoEpp='" + idCodigoEpp + "'";
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        if (rs.next()) {
            epp.setIdCodigoEpp(rs.getInt("idCodigoEpp"));
            epp.setNombreEpp(rs.getString("idCedula"));
            epp.setNombreEpp(rs.getString("nombre"));
            
            return epp;
        } else {
            return null;
        }
    }

    //Método para actualizar datos a epp en BD
    public boolean actualizarEpp(ElementoPp epp) throws SQLException {
        String sql = "update epp set idCedula=?, nombre=? where idCodigoEpp=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, epp.getIdCedula());
            ps.setString(2, epp.getNombreEpp());
            ps.setInt(3, epp.getIdCodigoEpp());
               
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
            return false;
        }
        return true;
        
    }
    
    //Método que permite eliminar datos
    public boolean eliminarEpp(int idCodigoEpp) {
        String sql = "Delete from epp where idCodigoEpp=" + idCodigoEpp;
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
    

