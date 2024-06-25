/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectostock.controller;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import proyectostock.repository.BaseRepository;

/**
 *
 * @author Neri
 */
public class Inventarios {
    
    
  public void MostrarProductosFaltantes(JTable paramTablaProductosFaltantes){
      
      BaseRepository baseRepository = new BaseRepository();
      DefaultTableModel modelo = new DefaultTableModel();
      TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel> (modelo);
      paramTablaProductosFaltantes.setRowSorter(OrdenarTabla);
      
      String sql="";
      
      modelo.addColumn("Producto");
      modelo.addColumn("StockActual");
      modelo.addColumn("TipoArticulo");
      modelo.addColumn("ModeloInventario");
      
      paramTablaProductosFaltantes.setModel(modelo);
      
      //ACÁ VA LA CONSULTA SIMPLONA CUANDO SE TERMINE EL TEMA DE EL PUNTO PEDIDO
      //PERSISTIR ATRIBUTOS PARA MOSTRARLOS AHORA
      sql = "";
      
      String[] datos = new String[8];
      Statement st;
      
      try {
          st = baseRepository.estableceConexion().createStatement();
          ResultSet rs = st.executeQuery(sql);
          
          while(rs.next()){
              datos[0]=rs.getString(1);
              datos[1]=rs.getString(2);
              datos[2]=rs.getString(3);
              datos[3]=rs.getString(4);
              
             modelo.addRow(datos);
          } 
          
          paramTablaProductosFaltantes.setModel(modelo);
          
          
      } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al mostrar los registros:" +e.toString());
      }
      
 
  }    
  
    public void MostrarProductosAReponer(JTable paramTablaProductosAReponer){
      
      BaseRepository baseRepository = new BaseRepository();
      DefaultTableModel modelo = new DefaultTableModel();
      TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel> (modelo);
      paramTablaProductosAReponer.setRowSorter(OrdenarTabla);
      
      String sql="";
      
      modelo.addColumn("Producto");
      modelo.addColumn("StockActual");
      modelo.addColumn("TipoArticulo");
      modelo.addColumn("ModeloInventario");
      
      paramTablaProductosAReponer.setModel(modelo);
      
      //ACÁ VA LA CONSULTA SIMPLONA CUANDO SE TERMINE EL TEMA DEL STOCK DE SEGURIDAD
      //PERSISTIR ATRIBUTOS PARA MOSTRARLOS AHORA
      sql = "";
      
      String[] datos = new String[8];
      Statement st;
      
      try {
          st = baseRepository.estableceConexion().createStatement();
          ResultSet rs = st.executeQuery(sql);
          
          while(rs.next()){
              datos[0]=rs.getString(1);
              datos[1]=rs.getString(2);
              datos[2]=rs.getString(3);
              datos[3]=rs.getString(4);
              
             modelo.addRow(datos);
          } 
          
          paramTablaProductosAReponer.setModel(modelo);
          
          
      } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al mostrar los registros:" +e.toString());
      }
      
 
  }    
    
    
}
