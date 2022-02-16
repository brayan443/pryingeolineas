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
public class UsuarioDAO {
   Conexion cn = new Conexion();
    //Definir un objeto para validar conexción
    Connection con;
    //Verificar las instrucciones de SQL y ejecutarlas
    PreparedStatement ps;
    //Carga el resultado de la consulta con un objeto de la clase
    ResultSet rs;
    //Instanciar la clase inquilinos, es decir, crear un objeto de la clase inquilinos
    Usuario user = new Usuario();

    //Método para insertar datos a Contratista en la BD (base de datos)
   public boolean validarUsuario(String usuario, String contraseña) throws ClassNotFoundException{
        boolean ok=false;
        Conexion conex = new Conexion();
        String sql = "Select * from usuario";
        try{
            con = cn.getConnection();
            PreparedStatement ps = conex.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           while (rs.next()){
            if (rs.getString("usuario").trim().equals(usuario) && 
                rs.getString("contrasenia").trim().equals(contraseña)){
                ok= true;
            }
           }
        }catch(SQLException ex){
            System.out.println(ex);
        }        
        return ok;
    }
      public boolean adicionar(Usuario user) {
        String sql = "insert into usuario(idusuario, nombreusuario,usuario,contrasenia,correo)values(?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getIdusuario());
            ps.setString(2,user.getNombreusuario());
            ps.setString(3, user.getUsuario());
            ps.setString(4, user.getContrasenia());
            ps.setString(5, user.getCorreo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
            return false;
        }
        return true;
    }
}
