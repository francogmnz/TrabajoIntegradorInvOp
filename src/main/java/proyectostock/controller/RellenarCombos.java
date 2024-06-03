/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectostock.controller;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import proyectostock.repository.BaseRepository;

/**
 *
 * @author Pc
 */
public class RellenarCombos {
    public void RellenarComboBox(String tabla, String valor, JComboBox combo){
        String sql = "SELECT * FROM " + tabla;
        Statement st;
        BaseRepository baseRepository = new BaseRepository();
        
        try {
          st = baseRepository.estableceConexion().createStatement();
          ResultSet rs = st.executeQuery(sql);
          while(rs.next()){
              combo.addItem(rs.getString(valor));
          }
      } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error:" +e.toString());
      }
    }
    
}
