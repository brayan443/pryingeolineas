/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingeolineas.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Usuario
 */
public class Conexion {
   
    /*Código utilizado para conectar la base de datos*/
   Connection con;
  //Atributos o variables de la clase, declaradas e inicializadas.
    public String bd = "bdingeolineas";
    public String login = "root";
    public String password = "";
    public String url = "jdbc:mysql://localhost:3306/"+bd+"?zeroDateTimeBehavior=CONVERT_TO_NULL";  
    public Conexion(){
     try{
       Class.forName("com.mysql.cj.jdbc.Driver");
       con = DriverManager.getConnection(url,login,password);
     }catch(Exception e){
       System.err.println("Error " + e);
     }
    }
    public Connection getConnection(){
       return con; 
    }
}

