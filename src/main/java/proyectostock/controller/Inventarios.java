/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectostock.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
    
    private JTextField txtArticulo;
    private JTextField txtLoteOptimo;
    private JTextField txtPuntoPedido;
    private JTextField txtStockSeguridad;
    private int codArticulo;

    // Constructor que acepta los JTextField como parámetros
    public Inventarios(JTextField txtArticulo, JTextField txtLoteOptimo, JTextField txtPuntoPedido, JTextField txtStockSeguridad) {
        this.txtArticulo = txtArticulo;
        this.txtLoteOptimo = txtLoteOptimo;
        this.txtPuntoPedido = txtPuntoPedido;
        this.txtStockSeguridad = txtStockSeguridad;
    }

    public JTextField getTxtArticulo() {
        return txtArticulo;
    }

    public void setTxtArticulo(JTextField txtArticulo) {
        this.txtArticulo = txtArticulo;
    }

    public JTextField getTxtLoteOptimo() {
        return txtLoteOptimo;
    }

    public void setTxtLoteOptimo(JTextField txtLoteOptimo) {
        this.txtLoteOptimo = txtLoteOptimo;
    }

    public JTextField getTxtPuntoPedido() {
        return txtPuntoPedido;
    }

    public void setTxtPuntoPedido(JTextField txtPuntoPedido) {
        this.txtPuntoPedido = txtPuntoPedido;
    }

    public JTextField getTxtStockSeguridad() {
        return txtStockSeguridad;
    }

    public void setTxtStockSeguridad(JTextField txtStockSeguridad) {
        this.txtStockSeguridad = txtStockSeguridad;
    }

    public int getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(int codArticulo) {
        this.codArticulo = codArticulo;
    }

    public void CalcularLoteFijo() {
        String codArticulo = txtArticulo.getText();
        double D = obtenerDemanda(codArticulo);
        double Cp = obtenerCostoPedido(codArticulo);
        double Ca = obtenerCostoAlmacenamiento(codArticulo);
        double L = obtenerDiasDemora(codArticulo);

        double loteOptimo = Math.sqrt(2 * D * (Cp / Ca));
        double puntoPedido = D * L;
        double stockSeguridad = 1.645 * Math.sqrt(L);

        txtLoteOptimo.setText(String.valueOf(loteOptimo));
        txtPuntoPedido.setText(String.valueOf(puntoPedido));
        txtStockSeguridad.setText(String.valueOf(stockSeguridad));

        actualizarArticulo(codArticulo, loteOptimo, puntoPedido, stockSeguridad);
    }

    private double obtenerDemanda(String codArticulo) {
        double demanda = 0.0;
        try (Connection con = new BaseRepository().estableceConexion()) {
            String query = "SELECT SUM(cantidad) FROM demanda WHERE codArticulo = ? ORDER BY fecha DESC LIMIT 12";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, codArticulo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                demanda = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return demanda;
    }

    private double obtenerCostoPedido(String codArticulo) {
        double costoPedido = 0.0;
        try (Connection con = new BaseRepository().estableceConexion()) {
            String query = "SELECT costoPedidoArticulo FROM articulo WHERE codArticulo = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, codArticulo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                costoPedido = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return costoPedido;
    }

    private double obtenerCostoAlmacenamiento(String codArticulo) {
        double costoAlmacenamiento = 0.0;
        try (Connection con = new BaseRepository().estableceConexion()) {
            String query = "SELECT costoAlmacenimientoArticulo FROM articulo WHERE codArticulo = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, codArticulo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                costoAlmacenamiento = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return costoAlmacenamiento;
    }

    private double obtenerDiasDemora(String codArticulo) {
        double diasDemora = 0.0;
        try (Connection con = new BaseRepository().estableceConexion()) {
            String query = "SELECT p.diasDemora FROM proveedor p JOIN articulo a ON p.tipoArticuloId = a.codigoTipoArticulo WHERE a.codArticulo = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, codArticulo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                diasDemora = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diasDemora;
    }

    private void actualizarArticulo(String codArticulo, double loteOptimo, double puntoPedido, double stockSeguridad) {
        try (Connection con = new BaseRepository().estableceConexion()) {
            String query = "UPDATE articulo SET loteOptimo = ?, puntoPedido = ?, stockSeguridad = ? WHERE codArticulo = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setDouble(1, loteOptimo);
            pst.setDouble(2, puntoPedido);
            pst.setDouble(3, stockSeguridad);
            pst.setString(4, codArticulo);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}