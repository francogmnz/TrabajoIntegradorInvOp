/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectostock.entities;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import proyectostock.repository.BaseRepository;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;

/**
 *
 * @author Juan
 */
public class TipoArticulo {
    
    private String nombreTipoArticulo;
    private int codigoTipoArticulo;

    public String getNombreTipoArticulo() {
        return nombreTipoArticulo;
    }

    public void setNombreTipoArticulo(String nombreTipoArticulo) {
        this.nombreTipoArticulo = nombreTipoArticulo;
    }

    public int getCodigoTipoArticulo() {
        return codigoTipoArticulo;
    }

    public void setCodigoTipoArticulo(int codigoTipoArticulo) {
        this.codigoTipoArticulo = codigoTipoArticulo;
    }
    
        public void MostrarCodigoPorTipoArticulo(JComboBox tipoArticuloCombo, JTextField idTipoArticulo){
        
        String consulta = "SELECT tipoarticulo.codigoTipoArticulo FROM tipoarticulo WHERE tipoarticulo.nombreTipoArticulo = ?";
        BaseRepository baseRepository = new BaseRepository();
        
        try {
          CallableStatement cs = baseRepository.estableceConexion().prepareCall(consulta);
          cs.setString(1, tipoArticuloCombo.getSelectedItem().toString());
          cs.execute();
          
          ResultSet rs = cs.executeQuery();
          
          if(rs.next()){
              idTipoArticulo.setText(rs.getString("codigoTipoArticulo"));
          }
          
          } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error:" +e.toString());
      }
    }

    
    
}
