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
public class DocumentoSgsstDAO {
     Conexion cn = new Conexion();
    //Definir un objeto para validar conexción
    Connection con;
    //Verificar las instrucciones de SQL y ejecutarlas
    PreparedStatement ps;
    //Carga el resultado de la consulta con un objeto de la clase
    ResultSet rs;
    //Instanciar la clase inquilinos, es decir, crear un objeto de la clase inquilinos
    DocumentoSgsst documento = new  DocumentoSgsst();
    //Método para insertar datos a inquilinos en la BD (base de datos)
public boolean adicionar(DocumentoSgsst documento) {
        String sql = "insert into documentosgsst(idCodigoProyecto, nombreDocumento)values(?,?)";
         con = cn.getConnection();
try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, documento.getIdCodigoProyecto());
            ps.setString(2, documento.getNombre());     
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
            return false;
        }
        return true;
    
}
public DocumentoSgsst consultarDocumento(int idCodigoSg) throws SQLException {
        String sql = "select * from documentosgsst where idCodigoSG=" + idCodigoSg+ " ";
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        if (rs.next()) {
            documento.setIdCodigoSg(rs.getInt("idCodigoSG"));
            documento.setIdCodigoProyecto(rs.getInt("idCodigoProyecto"));
            documento.setNombre(rs.getString("nombreDocumento"));         
             
            return documento;
        } else {

            return null;
        }
    }
public boolean actualizar(DocumentoSgsst documento) throws SQLException {
        String sql = "update documentosgsst set idCodigoSG=?, idCodigoProyecto=?, nombreDocumento=? where idCodigoSG=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,documento.getIdCodigoProyecto());
            ps.setString(2,documento.getNombre());
            ps.setInt(3,documento.getIdCodigoSg());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
            return false;
        }
        return true;
    
}
public boolean eliminar(int idCodigoSG) {
        String sql = "Delete from documentosgsst where idCodigoSG=" + idCodigoSG;
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

//Método que permite consultar todos los Documentos
    public ArrayList consultarDocumentos() throws SQLException {
        String sql = "Select * from documentosgsst";
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        ArrayList listDocument = new ArrayList();
        while (rs.next()) {
            documento.setIdCodigoSg(rs.getInt("codigo"));
            documento.setNombre(rs.getString("nombreDocumento"));
            documento.setIdCodigoProyecto(rs.getInt("idCodigoProyecto"));
            listDocument.add(new DocumentoSgsst(documento.getIdCodigoSg(), documento.getIdCodigoProyecto(), documento.getNombre()));
        }
        return listDocument;
    }
}

