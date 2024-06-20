/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectostock.controller;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import proyectostock.repository.BaseRepository;

/**
 *
 * @author Huilen
 */
public class CargarVenta {
        public void guardarVenta(){
        //Para guardar la venta en la bd
        
        }
        
        public void MostrarStockArticulo(JComboBox articuloCombo, JTextField stockArticulo){
        
        String consulta = "SELECT articulo.stockActualArticulo FROM articulo WHERE articulo.nombreArticulo = ?";
        BaseRepository baseRepository = new BaseRepository();
        
        try {
          CallableStatement cs = baseRepository.estableceConexion().prepareCall(consulta);
          cs.setString(1, articuloCombo.getSelectedItem().toString());
          cs.execute();
          
          ResultSet rs = cs.executeQuery();
          
          if(rs.next()){
              stockArticulo.setText(rs.getString("stockActualArticulo"));
          }
          
          } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error:" +e.toString());
      }
          
    
        }
}
