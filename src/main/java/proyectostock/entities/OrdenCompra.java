/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectostock.entities;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import proyectostock.repository.BaseRepository;

/**
 *
 * @author Juan
 */
public class OrdenCompra {
    
    private int numOrdenCompra;
    private LocalDate fechaCreacionOC;
    private EstadoOrdenCompra estadoOrdenCompra;
    private Proveedor proveedor;
    private Articulo articulo;
    private int cantArticulosOC;

    public int getNumOrdenCompra() {
        return numOrdenCompra;
    }

    public void setNumOrdenCompra(int numOrdenCompra) {
        this.numOrdenCompra = numOrdenCompra;
    }

    public LocalDate getFechaCreacionOC() {
        return fechaCreacionOC;
    }

    public void setFechaCreacionOC(LocalDate fechaCreacionOC) {
        this.fechaCreacionOC = fechaCreacionOC;
    }

    public EstadoOrdenCompra getEstadoOrdenCompra() {
        return estadoOrdenCompra;
    }

    public void setEstadoOrdenCompra(EstadoOrdenCompra estadoOrdenCompra) {
        this.estadoOrdenCompra = estadoOrdenCompra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantArticulosOC() {
        return cantArticulosOC;
    }

    public void setCantArticulosOC(int cantArticulosOC) {
        this.cantArticulosOC = cantArticulosOC;
    }
    

    

   public void MostrarOrdenesCompra(JTable paramTablaTotalOrdenCompra){
      
      BaseRepository baseRepository = new BaseRepository();
      DefaultTableModel modelo = new DefaultTableModel();
      TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel> (modelo);
      paramTablaTotalOrdenCompra.setRowSorter(OrdenarTabla);
      
      String sql="";
      
      modelo.addColumn("Número");
      modelo.addColumn("Fecha de creación");
      modelo.addColumn("Estado");     
      modelo.addColumn("Proveedor");
      modelo.addColumn("Artículo");  
      modelo.addColumn("Cantidad");
      
      paramTablaTotalOrdenCompra.setModel(modelo);
      
      //CORREGIIIIIIIIIIIIRRRRRR
      sql = "SELECT \n" +
      "    OrdenCompra.numOrdenCompra,\n" +
      "    OrdenCompra.fechaCreacionOC,\n" +
      "    EstadoOrdenCompra.nombreEstadoOC AS nombreEstado,\n" +
      "    Proveedor.nombreProveedor AS nombreProveedor,\n" +
      "    Articulo.nombreArticulo AS nombreArticulo,\n" +
      "    OrdenCompra.cantArticulosOC\n" +
      "FROM \n" +
      "    OrdenCompra\n" +
      "    INNER JOIN EstadoOrdenCompra ON OrdenCompra.codEstadoOC = EstadoOrdenCompra.codEstadoOC\n" +
      "    INNER JOIN Proveedor ON OrdenCompra.codProveedor = Proveedor.codProveedor\n" +
      "    INNER JOIN Articulo ON OrdenCompra.codArticulo = Articulo.codArticulo;";
      
      String[] datos = new String[6];
      Statement st;
      
      try {
          st = baseRepository.estableceConexion().createStatement();
          ResultSet rs = st.executeQuery(sql);
          
          while(rs.next()){
              datos[0]=rs.getString(1);
              datos[1]=rs.getString(2);
              datos[2]=rs.getString(3);
              datos[3]=rs.getString(4);
              datos[4]=rs.getString(5);
              datos[5]=rs.getString(6);
              
             modelo.addRow(datos);
          } 
          
          paramTablaTotalOrdenCompra.setModel(modelo);
          
          
      } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al mostrar los registros:" +e.toString());
      }
      
 
  }   

}
