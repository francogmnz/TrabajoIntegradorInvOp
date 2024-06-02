/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectostock.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class BaseRepository {
    
    Connection conectar = null;
    String usuario = "root";
    String contrasenia = "root";
    String bd = "bdproyectostock";
    String ip = "localhost";
    String puerto = "3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
   public Connection estableceConexion() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contrasenia);
         //   JOptionPane.showMessageDialog(null, "Conexión establecida");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+ e.toString());
        }
        
        return conectar; 
    } 
   
   
}
