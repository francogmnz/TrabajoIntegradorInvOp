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
import javax.swing.JTextField;
import proyectostock.repository.BaseRepository;

/**
 *
 * @author Pc
 */
public class RellenarCombos {
    private int codProveedor;

    public int getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }
    
    
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
     // Para el repo
        public void RellenarComboLoteFijo(String tabla, String valor, JComboBox combo){
        String sql = "SELECT * FROM " + tabla + " WHERE modeloInventario = 1";

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
        // Para el repo
        public void RellenarComboIntervaloFijo(String tabla, String valor, JComboBox combo){
        String sql = "SELECT * FROM " + tabla + " WHERE modeloInventario = 2";

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
        
        public void RellenarComboArticulosProveedores(String tabla, String valor, JComboBox combo, JTextField paramCodProveedor){
        setCodProveedor(Integer.parseInt(paramCodProveedor.getText()));    
    /*    String sql = "SELECT articulo.nombreArticulo FROM " + tabla + " JOIN TipoArticulo ON articulo.codigoTipoArticulo = tipoarticulo.codigoTipoArticulo\n" +
"JOIN Proveedor ON proveedor.tipoArticuloId = tipoarticulo.codigoTipoArticulo WHERE articulo.codigoTipoArticulo = " + codProveedor +";";
*/
    String sql = "SELECT articulo.nombrearticulo\n" +
    "FROM articulo\n" +   
    "JOIN tipoarticulo ON articulo.codigotipoarticulo = tipoarticulo.codigotipoarticulo\n" +
    "JOIN proveedor ON tipoarticulo.codigotipoarticulo = proveedor.tipoarticuloId\n" +
    "WHERE proveedor.codproveedor = " +codProveedor+ ";";
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
