/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectostock.entities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Franco
 */
import java.sql.Statement;
import javax.swing.JTextField;
import proyectostock.repository.BaseRepository;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

public class Venta {

    private Date fechaVenta;

    public Venta() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public int getNumVenta() {
        return numVenta;
    }

    public int getCodArticulo() {
        return codArticulo;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setNumVenta(int numVenta) {
        this.numVenta = numVenta;
    }

    public void setCodArticulo(int codArticulo) {
        this.codArticulo = codArticulo;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }
    private int numVenta;
    private int codArticulo;
    private int cantidadVendida;

    public Venta(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public Venta(Date fechaVenta, int numVenta, int codArticulo, int cantidadVendida) {
        this.fechaVenta = fechaVenta;
        this.numVenta = numVenta;
        this.codArticulo = codArticulo;
        this.cantidadVendida= cantidadVendida;
    }


       public void MostrarVentas(JTable paramTablaVenta){
      
      BaseRepository baseRepository = new BaseRepository();
      DefaultTableModel modelo = new DefaultTableModel();
      TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel> (modelo);
      paramTablaVenta.setRowSorter(OrdenarTabla);
      
      String sql="";
      
      modelo.addColumn("Numero");
      modelo.addColumn("Fecha");
      modelo.addColumn("Cantidad");
      modelo.addColumn("Codigo Articulo");

      
      paramTablaVenta.setModel(modelo);
      
      sql = "SELECT venta.numVenta, venta.fechaVenta, venta.cantidad, venta.codArticulo\n" +
      "FROM venta;";
      
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
          
          paramTablaVenta.setModel(modelo);
          
          
      } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al mostrar los registros:" +e.toString());
      }
      
 
  }
}



