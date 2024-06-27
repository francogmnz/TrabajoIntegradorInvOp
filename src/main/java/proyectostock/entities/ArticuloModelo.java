/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectostock.entities;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import proyectostock.repository.BaseRepository;

/**
 *
 * @author Pc
 */
public class ArticuloModelo {
    private int codArticuloModelo;
    private String nombreArticuloModelo;

    public int getCodArticuloModelo() {
        return codArticuloModelo;
    }

    public void setCodArticuloModelo(int codArticuloModelo) {
        this.codArticuloModelo = codArticuloModelo;
    }

    public String getNombreArticuloModelo() {
        return nombreArticuloModelo;
    }

    public void setNombreArticuloModelo(String nombreArticuloModelo) {
        this.nombreArticuloModelo = nombreArticuloModelo;
    }

    public void MostrarCodigoPorModeloInventario(JComboBox tipoModelo, JTextField idModelo){
        
        String consulta = "SELECT articulomodelo.codarticulomodelo FROM articulomodelo WHERE articulomodelo.nombrearticulomodelo = ?";
        BaseRepository baseRepository = new BaseRepository();
        
        try {
          CallableStatement cs = baseRepository.estableceConexion().prepareCall(consulta);
          cs.setString(1, tipoModelo.getSelectedItem().toString());
          cs.execute();
          
          ResultSet rs = cs.executeQuery();
          
          if(rs.next()){
              idModelo.setText(rs.getString("codArticuloModelo"));
          }
          
          } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error:" +e.toString());
      }
    } 
    
}
